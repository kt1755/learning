package com.springtut.pool;

import java.sql.Connection;

public interface ConnectionPool {

	public void setupDataSource() throws Exception;
	
	public Connection getConnection() throws Exception;
}
