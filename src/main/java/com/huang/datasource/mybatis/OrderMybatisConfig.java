package com.huang.datasource.mybatis;

import com.huang.datasource.config.OrderConfig;
import com.huang.datasource.util.DataSourceUtil;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;


/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/11/23 13:36
 */
@Configuration
@MapperScan(basePackages = "com.huang.datasource.mapper.order", sqlSessionTemplateRef = "orderSqlSessionTemplate")
public class OrderMybatisConfig {
    @Primary
    @Bean()
    public DataSource orderDataSource(OrderConfig orderConfig) throws SQLException {
        return DataSourceUtil.create(orderConfig, "orderDataSource");
    }


    @Bean()
    public SqlSessionFactory orderSqlSessionFactory(@Qualifier("orderDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }


    @Bean()
    public SqlSessionTemplate orderSqlSessionTemplate(
            @Qualifier("orderSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
