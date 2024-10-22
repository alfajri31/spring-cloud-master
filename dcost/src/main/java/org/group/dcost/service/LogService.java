package org.group.dcost.service;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LogService implements ILogService {


    @Override
    public List<Object> checkLog() {
        List<Object> userSubscribes = new ArrayList<>();
        try (RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")))) {

            org.elasticsearch.action.search.SearchRequest searchRequest =
                    new SearchRequest("user_subscribe");
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(QueryBuilders.matchAllQuery());
            searchRequest.source(searchSourceBuilder);

            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

            for (SearchHit hit : searchResponse.getHits()) {
                // Map the SearchHit to a UserSubscribe object
                Object userSubscribe = hit.getSourceAsMap();
                userSubscribes.add(userSubscribe);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return userSubscribes;
    }

    @Override
    public List<Object> checkLogByDate(String date) {
        List<Object> userSubscribes = new ArrayList<>();
        try (RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")))) {
            SearchRequest searchRequest = new SearchRequest("user_subscribe");
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(QueryBuilders.rangeQuery("currentDate")
                    .gte(date));
            searchRequest.source(searchSourceBuilder);
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            for (SearchHit hit : searchResponse.getHits()) {
                Object userSubscribe = hit.getSourceAsMap();
                userSubscribes.add(userSubscribe);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userSubscribes;
    }
}
