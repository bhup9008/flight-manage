package com.codingworld.service1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class CommanConfig {

    @Bean
   public HttpHeaders getHttpHeader(){
       return new HttpHeaders();
   }
}
