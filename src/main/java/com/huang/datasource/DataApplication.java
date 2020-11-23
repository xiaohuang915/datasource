package com.huang.datasource;

import com.huang.datasource.config.OrderConfig;
import com.huang.datasource.config.PayConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/11/23 13:20
 */
@SpringBootApplication
@EnableConfigurationProperties({OrderConfig.class, PayConfig.class})
public class DataApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataApplication.class, args);
    }
}
