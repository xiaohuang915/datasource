package com.huang.datasource.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/11/23 13:30
 */
@Getter
@Setter
@ConfigurationProperties("mysql.datasource.pay")
public class PayConfig {
    private String url;
    private String username;
    private String password;
    private int minPoolSize;
    private int maxPoolSize;
    private int maxLifetime;
    private int borrowConnectionTimeout;
    private int loginTimeout;
    private int maintenanceInterval;
    private int maxIdleTime;
    private String testQuery;
    private String driverClassName;
}
