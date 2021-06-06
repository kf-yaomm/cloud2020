package com.atming.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Yang Hao
 * @description
 * @date 2020-09-14 16:54
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced   注释掉为了自己写Ribben轮询算法
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
