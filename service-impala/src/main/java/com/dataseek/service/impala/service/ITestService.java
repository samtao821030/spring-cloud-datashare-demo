package com.dataseek.service.impala.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

//测试接口
public interface ITestService {
    //查询人员基本信息
    public List<JSONObject> queryPeopleList(Integer page,Integer num);
}
