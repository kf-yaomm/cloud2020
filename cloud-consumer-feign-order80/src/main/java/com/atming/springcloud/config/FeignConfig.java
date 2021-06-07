package com.atming.springcloud.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignConfig {


    @Bean
    Logger.Level fignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
