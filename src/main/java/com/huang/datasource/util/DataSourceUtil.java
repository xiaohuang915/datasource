package com.huang.datasource.util;

import com.huang.datasource.config.BaseConfig;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/11/23 17:20
 */
public class DataSourceUtil {
    
    public static DataSource create(BaseConfig baseConfig,String resourceName) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(baseConfig.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(baseConfig.getPassword());
        mysqlXaDataSource.setUser(baseConfig.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName(resourceName);
        xaDataSource.setMinPoolSize(baseConfig.getMinPoolSize());
        xaDataSource.setMaxPoolSize(baseConfig.getMaxPoolSize());
        xaDataSource.setMaxLifetime(baseConfig.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(baseConfig.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(baseConfig.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(baseConfig.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(baseConfig.getMaxIdleTime());
        xaDataSource.setTestQuery(baseConfig.getTestQuery());
        xaDataSource.setXaDataSourceClassName(baseConfig.getDriverClassName());
        return xaDataSource;
    }
}
