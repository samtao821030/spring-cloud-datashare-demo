package com.dataseek.service.impala.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/impala/test")
    public String test(){
        return "这是Impala Test";
    }
}
