package com.huang.datasource.util;

import com.huang.datasource.config.BaseProperties;
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
    
    public static DataSource create(BaseProperties baseProperties, String resourceName) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(baseProperties.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(baseProperties.getPassword());
        mysqlXaDataSource.setUser(baseProperties.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName(resourceName);
        xaDataSource.setMinPoolSize(baseProperties.getMinPoolSize());
        xaDataSource.setMaxPoolSize(baseProperties.getMaxPoolSize());
        xaDataSource.setMaxLifetime(baseProperties.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(baseProperties.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(baseProperties.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(baseProperties.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(baseProperties.getMaxIdleTime());
        xaDataSource.setTestQuery(baseProperties.getTestQuery());
        xaDataSource.setXaDataSourceClassName(baseProperties.getDriverClassName());
        return xaDataSource;
    }
}
