package com.huang.datasource.mybatis;

import com.huang.datasource.config.OrderConfig;
import com.huang.datasource.config.PayConfig;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
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
    @Bean(name = "payDataSource")
    public DataSource testDataSource(PayConfig payConfig) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(payConfig.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(payConfig.getPassword());
        mysqlXaDataSource.setUser(payConfig.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("payDataSource");
        xaDataSource.setMinPoolSize(payConfig.getMinPoolSize());
        xaDataSource.setMaxPoolSize(payConfig.getMaxPoolSize());
        xaDataSource.setMaxLifetime(payConfig.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(payConfig.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(payConfig.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(payConfig.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(payConfig.getMaxIdleTime());
        xaDataSource.setTestQuery(payConfig.getTestQuery());
        xaDataSource.setXaDataSourceClassName(payConfig.getDriverClassName());
        return xaDataSource;
    }


    @Bean(name = "paySqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("payDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }


    @Bean(name = "paySqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("paySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
