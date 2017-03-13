package com.springtut.pool;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.springtut.constants.Constants;
import com.springtut.utilities.CommonUtils;
import com.springtut.utilities.LogUtils;

public class JDBCConnectionPool {
	private static DataSource datasource;
	

	public static void setupDataSource() throws Exception {
		System.out.println("Init datasource...");
		
		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setDriverClassName(CommonUtils.getProperty(Constants.JDBC_PROPERTIES.DRIVER));
		dataSource.setUrl(CommonUtils.getProperty(Constants.JDBC_PROPERTIES.URL));
		dataSource.setUsername(CommonUtils.getProperty(Constants.JDBC_PROPERTIES.USERNAME));
		dataSource.setPassword(CommonUtils.getProperty(Constants.JDBC_PROPERTIES.PASSWORD));
		
		dataSource.setMaxIdle(16);
		dataSource.setMaxTotal(16);
		
		datasource = dataSource;
//		System.out.println("Init complete !");
		LogUtils.getInstance().message("Init completed !");
	}
	
	public Connection getConnection() throws Exception {
		// TODO Auto-generated method stub
		return datasource.getConnection();
	}

}
