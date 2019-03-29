package com.microservices.currencyconvertion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.microservices.currencyconvertion")
@EnableDiscoveryClient
public class CurrencyConvertionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConvertionApplication.class, args);
    }

}
