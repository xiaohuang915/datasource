package com.huang.datasource;

import com.huang.datasource.config.OrderProperties;
import com.huang.datasource.config.PayProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/11/23 13:20
 */
@SpringBootApplication
@EnableConfigurationProperties({OrderProperties.class, PayProperties.class})
public class DataApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataApplication.class, args);
    }
}
