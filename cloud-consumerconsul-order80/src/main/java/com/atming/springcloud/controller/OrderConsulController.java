package com.atming.springcloud.controller;

import com.atming.springcloud.entities.CommonResult;
import com.atming.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Yang Hao
 * @description
 * @date 2020-09-14 16:51
 */
@RestController
@Slf4j
public class OrderConsulController {
    public static final String INVOKE_URL = "http://localhost:8001/";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment ) {

        return restTemplate.postForObject(INVOKE_URL+"payment/create", payment, CommonResult.class);
    }



    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id ) {

        return restTemplate.getForObject(INVOKE_URL+"payment/get/"+id, CommonResult.class);
    }



}
