package org.group.dcost.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.group.dcost.dto.request.InquiryReq;
import org.group.dcost.dto.request.SyncRequest;
import org.group.dcost.dto.request.callback.DanaCallbackMappingRequest;
import org.group.dcost.dto.request.callback.GopayCallbackMappingRequest;
import org.group.dcost.dto.request.callback.ShopeeCallbackMappingRequest;
import org.group.dcost.dto.response.CommonResp;
import org.group.dcost.dto.response.InquiryResp;
import org.group.dcost.entity.UserSubscribe;
import org.group.dcost.repo.UserSubscribeRepository;
import org.group.dcost.util.Util;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DCostService implements IDCostService {

    private final UserSubscribeRepository userSubscribeRepository;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public CommonResp syncService(SyncRequest syncRequest) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        String formattedDate = dateFormat.format(currentDate);
        Integer randomAmount = Util.getRandomValue();
        syncRequest.getDigitalPaymentIds().stream().forEach(id -> {
            Optional<UserSubscribe> opt = userSubscribeRepository.findByCurrentDateAndDigitalPaymentId(formattedDate, id);
            if (opt.isEmpty()) {
                UserSubscribe userSubscribe = new UserSubscribe();
                userSubscribe.setUserId(syncRequest.getUserId());
                userSubscribe.setDigitalPaymentId(id);
                userSubscribe.setDailyAmount(randomAmount);
                userSubscribe.setMonthlyAmount(randomAmount * 30);
                userSubscribe.setYearlyAmount(randomAmount * 365);
                userSubscribe.setCurrentDate(formattedDate);
                userSubscribeRepository.save(userSubscribe);
            }
            else {
                //TODO Broker Message kafka
                String topicName = "simulate-callback-to-consumer";
                ObjectMapper objectMapper = new ObjectMapper();
                DanaCallbackMappingRequest dana =DanaCallbackMappingRequest.builder()
                        .userId(syncRequest.getUserId())
                        .requestId(Util.getRandomUUID())
                        .digitalPaymentId(syncRequest.getDigitalPaymentIds().get(0))
                        .requestName("dana")
                        .paidAmount(Util.getRandomValue())
                        .date(formattedDate).build();
                try {
                    String send = objectMapper.writeValueAsString(dana);
                    kafkaTemplate.send(topicName,send);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                GopayCallbackMappingRequest gopay =GopayCallbackMappingRequest.builder()
                        .userId(syncRequest.getUserId())
                        .requestId(Util.getRandomUUID())
                        .requestName("gopay")
                        .paidAmount(Util.getRandomValue())
                        .digitalPaymentId(syncRequest.getDigitalPaymentIds().get(1))
                        .date(formattedDate).build();
                try {
                    String send = objectMapper.writeValueAsString(gopay);
                    kafkaTemplate.send(topicName,send);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                ShopeeCallbackMappingRequest shopee =ShopeeCallbackMappingRequest.builder()
                        .userId(syncRequest.getUserId())
                        .requestId(Util.getRandomUUID())
                        .requestName("shopee")
                        .paidAmount(Util.getRandomValue())
                        .digitalPaymentId(syncRequest.getDigitalPaymentIds().get(2))
                        .date(formattedDate).build();
                try {
                    String send = objectMapper.writeValueAsString(shopee);
                    kafkaTemplate.send(topicName,send);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        /**
         * store every request to elastic search for logging
         */
        try (RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")))) {

            syncRequest.getDigitalPaymentIds().forEach(id -> {
                XContentBuilder builder;
                try {
                    builder = XContentFactory.jsonBuilder()
                            .startObject()
                            .field("id",Util.getRandomUUID())
                            .field("userId", syncRequest.getUserId())
                            .field("digitalPaymentId", id)
                            .field("dailyAmount", randomAmount)
                            .field("monthlyAmount", randomAmount * 30)
                            .field("yearlyAmount", randomAmount * 365)
                            .field("currentDate", formattedDate)
                            .endObject();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                org.elasticsearch.action.index.IndexRequest request =
                        new org.elasticsearch.action.index.IndexRequest("user_subscribe");
                request.source(builder);
                try {
                    client.index(request, RequestOptions.DEFAULT);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            CommonResp response = new CommonResp();
            response.setSuccess(true);
            response.setMessage("Random amount synced successfully");
            return response;
        }
    }

    @Override
    @CacheEvict(value="userSubscribe",key = "#inquiryReq.getUserId()")
    public InquiryResp inquirySubscribe(InquiryReq inquiryReq) {
        Pageable paging = PageRequest.of(inquiryReq.getPage(),inquiryReq.getSize());
        Page<UserSubscribe> userSubscribes = userSubscribeRepository.findAllByUserId(inquiryReq.getUserId(),paging);
        userSubscribes.getContent().forEach(userSubscribe -> {
            userSubscribe.setDailyAmountId(Util.convertToIndonesianRupiah(userSubscribe.getDailyAmount()));
            userSubscribe.setMonthlyAmountId(Util.convertToIndonesianRupiah(userSubscribe.getMonthlyAmount()));
            userSubscribe.setYearlyAmountId(Util.convertToIndonesianRupiah(userSubscribe.getYearlyAmount()));
        });
        return InquiryResp.builder()
                .page(inquiryReq.getPage())
                .data(userSubscribes.stream().collect(Collectors.toList()))
                .totalPages(userSubscribes.getTotalPages())
                .totalSize(userSubscribes.getSize())
                .build();
    }

    @Override
    public CommonResp resetSync(SyncRequest syncRequest) {
        Pageable paging = PageRequest.of(0, 5); // only have 5 source
        Page<UserSubscribe> userSubscribes = userSubscribeRepository.findAllByUserId(syncRequest.getUserId(),paging);
        if(userSubscribes.getSize()>0) {
            userSubscribes.stream().forEach(data ->{
                data.setDailyAmount(0);
                data.setMonthlyAmount(0);
                data.setYearlyAmount(0);
                userSubscribeRepository.save(data);
            });
        }
        CommonResp response = new CommonResp();
        response.setSuccess(true);
        response.setMessage("successful been reset");
        return response;
    }

}
