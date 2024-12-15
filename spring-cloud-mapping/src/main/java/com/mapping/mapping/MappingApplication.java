package com.mapping.mapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapping.entity.GlobalTokenEntity;
import com.mapping.model.reloadly.RequestTokenModel;
import com.mapping.model.reloadly.ResponseTokenModel;
import com.mapping.repository.GlobalTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.mapping")
@EnableJpaRepositories(basePackages = {"com.mapping.repository"})
@EntityScan("com.mapping.entity")
@EnableEurekaClient
public class MappingApplication {

    public String accessToken;

    @Autowired
    private GlobalTokenRepository globalTokenRepository;

    @Autowired
    public Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(MappingApplication.class, args);
    }

    @Bean
    public void getAccessToken() {
        try {
            String url = environment.getProperty("get_access_token_url");
            RequestTokenModel requestTokenModel = new RequestTokenModel();
            requestTokenModel.setClientId(environment.getProperty("api_client_id"));
            requestTokenModel.setClientSecret(environment.getProperty("api_client_secret"));
            requestTokenModel.setAudience(environment.getProperty("audience"));
            requestTokenModel.setGrantType(environment.getProperty("grant_type"));
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> result = restTemplate.postForEntity(url, requestTokenModel, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            ResponseTokenModel responseTokenModel = objectMapper.readValue(result.getBody(), ResponseTokenModel.class);
            accessToken = responseTokenModel.getAccessToken().replace("Bearer","");
            GlobalTokenEntity globalTokenEntity = new GlobalTokenEntity();
            globalTokenEntity.setAccessToken(accessToken);
            globalTokenRepository.save(globalTokenEntity);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getVariabelToken() {
        return this.accessToken;
    }

}
