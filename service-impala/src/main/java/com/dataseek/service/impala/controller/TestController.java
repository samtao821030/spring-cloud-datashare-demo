package com.dataseek.service.impala.controller;

import com.alibaba.fastjson.JSONObject;
import com.dataseek.service.impala.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/impala")
public class TestController {
    @Autowired
    private ITestService testService;

    @RequestMapping(value="/people_list",method = RequestMethod.GET)
    public List<JSONObject> test(@RequestParam Integer page_no, @RequestParam Integer page_num){
        return testService.queryPeopleList(page_no,page_num);
    }
}
