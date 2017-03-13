package com.springtut.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {

	private static LogUtils instance;
	
	private static Logger logger;
	
	private LogUtils() {
		// TODO Auto-generated constructor stub
		logger = LoggerFactory.getLogger(this.getClass());
	}
	
	public static LogUtils getInstance() {
		if(instance == null) instance = new LogUtils();
		return instance;
	}
	
	public void message(String message) {
		
	}
	
	public void info(String message) {
		logger.info(message);
	}
	
	public void error(Exception e) {
		
	}
}
