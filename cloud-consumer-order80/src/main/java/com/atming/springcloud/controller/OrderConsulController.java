package com.atming.springcloud.controller;

import com.atming.springcloud.entities.CommonResult;
import com.atming.springcloud.entities.Payment;
import com.atming.springcloud.lb.MyLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author Yang Hao
 * @description
 * @date 2020-09-14 16:51
 */
@RestController
@Slf4j
public class OrderConsulController {
   // public static final String INVOKE_URL = "http://localhost:8001";
    public static final String INVOKE_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;


    @Resource
    private MyLoadBalancer myLoadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;


    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment ) {

        return restTemplate.postForObject(INVOKE_URL+"/payment/create", payment, CommonResult.class);
    }



    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id ) {

        return restTemplate.getForObject(INVOKE_URL+"/payment/get/"+id, CommonResult.class);
    }



    @GetMapping(value = "/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id ) {

        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(INVOKE_URL + "/payment/get/" + id, CommonResult.class);

        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return  forEntity.getBody();
        }else {
            return new CommonResult<>(444,"操作失败！");
        }

    }


    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = myLoadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }


    /**
     * P94用,sleuth+zipkin链路监控使用
     *
     * @return
     */
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zipkin/", String.class);
        return result;
    }





}
