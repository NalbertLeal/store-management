package com.nalbertgml.sellsMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SellsMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellsMicroserviceApplication.class, args);
    }

}
