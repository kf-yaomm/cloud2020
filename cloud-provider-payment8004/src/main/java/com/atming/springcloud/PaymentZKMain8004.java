package com.atming.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description
 * @date 2020-09-15 17:29
 */
@SpringBootApplication
@EnableDiscoveryClient //注册中心注册服务用   consul zookeeper
public class PaymentZKMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentZKMain8004.class, args);
    }

}
