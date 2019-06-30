package com.dataseek.service.impala.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dataseek.service.impala.mapper.JSONObjectMapper;
import com.dataseek.service.impala.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestService implements ITestService {
    @Autowired
    private JdbcTemplate impalaJdbcTemplate;

    public List<JSONObject> queryPeopleList(Integer page_no, Integer page_num) {
        String query_sql = "select * from test_table2 order by age limit ? offset ? ";
        Integer limit_value = page_num;
        Integer offset_value = (page_no-1)*page_num;
        Object[] params = new Object[]{limit_value,offset_value};
        List<JSONObject> peopleList = impalaJdbcTemplate.query(query_sql,params,new JSONObjectMapper());
        return peopleList;
    }
}
