package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

@Configuration
public class PreAndPostFilter
{

    final Logger logger = LoggerFactory.getLogger(PreAndPostFilter.class);

    @Bean
    @Order(1)
    public GlobalFilter secondFilter() {
       return ((exchange, chain) -> {
           logger.info("second pre-filter executed");
           return chain.filter(exchange).then(Mono.fromRunnable( ()->{
               logger.info("second post-filter executed");
           }));
       });
    }

    @Bean
    @Order(2)
    public GlobalFilter thirdFilter() {
        return ((exchange, chain) -> {
            logger.info("third pre-filter executed");
            return chain.filter(exchange).then(Mono.fromRunnable( ()->{
                logger.info("third post-filter executed");
            }));
        });
    }

    @Bean
    @Order(3)
    public GlobalFilter fourthFilter() {
        return ((exchange, chain) -> {
            logger.info("post pre-filter executed");
            return chain.filter(exchange).then(Mono.fromRunnable( ()->{
                logger.info("post post-filter executed");
            }));
        });
    }
}
