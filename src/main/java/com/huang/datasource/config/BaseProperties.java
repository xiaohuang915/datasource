package com.huang.datasource.config;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/11/23 17:17
 */
@Getter
@Setter
public class BaseProperties {
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
