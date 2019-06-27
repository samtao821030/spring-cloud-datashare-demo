package com.dataseek.service.impala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ImpalaApplication {


    public static void main(String[] args) {
        SpringApplication.run(ImpalaApplication.class, args);
    }
}
