package com.dataseek.service.datashare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/datashare")
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/people_list",method = RequestMethod.GET)
    public String test(@RequestParam Integer page_no, @RequestParam Integer page_num){
        Map<String,Object> params_map = new HashMap<String, Object>();
        params_map.put("page_no",page_no);
        params_map.put("page_num",page_num);
        String json_string = restTemplate.getForEntity("http://impala/impala/people_list?page_no={page_no}&page_num={page_num}",String.class,params_map).getBody();
        return json_string;
    }
}
