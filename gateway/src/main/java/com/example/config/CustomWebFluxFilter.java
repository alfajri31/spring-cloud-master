package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

//@Configuration
//@EnableWebFluxSecurity
public class CustomWebFluxFilter {

    @Autowired
    public Environment environment;

//    @Bean
//    SecurityWebFilterChain webHttpSecurity(ServerHttpSecurity http) {
//        http.authorizeExchange( authorizeExchangeSpec -> {
//            authorizeExchangeSpec.pathMatchers(environment.getProperty("actuator.url.path")).permitAll();
//        });
//        return http.build();
//    }
}
