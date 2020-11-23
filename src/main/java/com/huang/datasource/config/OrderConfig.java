package com.huang.datasource.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/11/23 13:30
 */
@Getter
@Setter
@ConfigurationProperties("mysql.datasource.order")
public class OrderConfig extends BaseConfig{

}