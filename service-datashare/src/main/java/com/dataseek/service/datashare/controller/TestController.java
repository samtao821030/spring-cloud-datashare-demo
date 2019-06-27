package com.dataseek.service.datashare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/datashare/test")
    public String test(){
        String msg = restTemplate.getForEntity("http://impala/impala/test",String.class).getBody();
        return msg;
    }
}
