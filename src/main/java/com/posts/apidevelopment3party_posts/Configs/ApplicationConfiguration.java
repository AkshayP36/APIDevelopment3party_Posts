package com.posts.apidevelopment3party_posts.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApplicationConfiguration {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
