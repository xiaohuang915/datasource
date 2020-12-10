package com.huang.datasource.config;

import com.huang.datasource.util.DataSourceUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;


/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/11/23 13:36
 */
@Configuration
@MapperScan(basePackages = "com.huang.datasource.mapper.pay", sqlSessionTemplateRef = "paySqlSessionTemplate")
public class PayMybatisConfig {

    @Bean()
    public DataSource payDataSource(PayProperties payConfig) throws SQLException {
        return DataSourceUtil.create(payConfig);
    }

    @Bean()
    public SqlSessionFactory paySqlSessionFactory(@Qualifier("payDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean()
    public SqlSessionTemplate paySqlSessionTemplate(
            @Qualifier("paySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
