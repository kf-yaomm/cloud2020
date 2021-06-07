package com.atming.springcloud.service;

import com.atming.springcloud.entities.CommonResult;
import com.atming.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Yang Hao
 * @description
 * @date 2020-09-16 16:39
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);


    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut();


}
