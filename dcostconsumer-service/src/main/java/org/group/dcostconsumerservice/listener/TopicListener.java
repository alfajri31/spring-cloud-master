package org.group.dcostconsumerservice.listener;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.group.dcostconsumerservice.dto.GeneralCallbackMapping;
import org.group.dcostconsumerservice.entity.UserSubscribe;
import org.group.dcostconsumerservice.repository.UserSubscribeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TopicListener {

    @Value("${topic.name.consumer")
    private String topicName;

    private final UserSubscribeRepository userSubscribeRepository;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "SIMULATE")
    public void consume(ConsumerRecord<String, String> payload) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        String formattedDate = dateFormat.format(currentDate);
        log.info("Received message: {}", payload.value());
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GeneralCallbackMapping data  = objectMapper.readValue(payload.value(), GeneralCallbackMapping.class);
            Optional<UserSubscribe> opt = userSubscribeRepository
                    .findByUserIdAndDigitalPaymentIdAndCurrentDate(data.getUserId(),data.getDigitalPaymentId(),formattedDate);
            if(opt.isPresent()) {
                UserSubscribe user = opt.get();
                user.setDigitalPaymentName(data.getRequestName());
                user.setDigitalPaymentName(data.getRequestName());
                user.setDailyAmount((user.getDailyAmount()) + data.getPaidAmount());
                user.setMonthlyAmount((user.getDailyAmount()) * 30);
                user.setYearlyAmount((user.getDailyAmount()) * 365);
                userSubscribeRepository.save(user);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}

