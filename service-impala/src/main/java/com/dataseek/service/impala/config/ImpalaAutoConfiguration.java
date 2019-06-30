package com.dataseek.service.impala.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@org.springframework.context.annotation.Configuration
@EnableConfigurationProperties(ImpalaProperties.class)
public class ImpalaAutoConfiguration {
    @Autowired
    private ImpalaProperties impalaProperties;

    @Bean(name="impalaDataSource")
    public DruidDataSource initBasicDataSource(){
        String impala_host = impalaProperties.getImpala_host();
        Integer impala_port = impalaProperties.getImpala_port();
        String impala_username = impalaProperties.getImpala_username();
        String impala_url="jdbc:hive2://"+impala_host+":"+impala_port+"/;auth=noSasl";
        DruidDataSource basicDataSource = new DruidDataSource();
        basicDataSource.setDriverClassName("org.apache.hive.jdbc.HiveDriver");
        basicDataSource.setUrl(impala_url);
        basicDataSource.setUsername(impala_username);
        basicDataSource.setPassword("");
        basicDataSource.setInitialSize(20);
        basicDataSource.setMaxActive(30);
        basicDataSource.setMinIdle(10);
        basicDataSource.setValidationQuery("select now() ");
        basicDataSource.setTestOnBorrow(true);
        basicDataSource.setDefaultAutoCommit(false);
        return basicDataSource;
    }

    @Bean(name="impalaJdbcTemplate")
    public JdbcTemplate initJdbcTemplate(@Qualifier("impalaDataSource")DruidDataSource impalaDataSource){
        JdbcTemplate impalaJdbcTemplate = new JdbcTemplate();
        impalaJdbcTemplate.setDataSource(impalaDataSource);
        return impalaJdbcTemplate;
    }


}
