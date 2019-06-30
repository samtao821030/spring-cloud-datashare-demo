package com.dataseek.service.impala.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="impala")
public class ImpalaProperties {
    //impala服务主机名
    private String impala_host;
    //impala主机端口号
    private Integer impala_port;
    //impala服务用户名
    private String impala_username;

    public String getImpala_host() {
        return impala_host;
    }

    public void setImpala_host(String impala_host) {
        this.impala_host = impala_host;
    }

    public Integer getImpala_port() {
        return impala_port;
    }

    public void setImpala_port(Integer impala_port) {
        this.impala_port = impala_port;
    }

    public String getImpala_username() {
        return impala_username;
    }

    public void setImpala_username(String impala_username) {
        this.impala_username = impala_username;
    }
}
