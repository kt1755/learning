package com.springtut.utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommonUtils {
	
	public static String getProperty(String name) {
		InputStream input;
		Properties properties = new Properties();
		try {
			input = new FileInputStream("/home/kt1755/database.properties");
			properties.load(input);
			LogUtils.getInstance().message("Load properties: " + name + " : " + properties.getProperty(name));
			return properties.getProperty(name);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger("Error").log(Level.WARNING, e.getMessage(), e);
		}
		return null;
	}
	
	public static String getProperties(String name, String nvl) {
		InputStream input;
		Properties properties = new Properties();
		try {
			input = new FileInputStream("/home/kt1755/database.properties");
			properties.load(input);
			return properties.getProperty(name) == null ? nvl : properties.getProperty(name);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger("Error").log(Level.WARNING, e.getMessage(), e);
		}
		return null;
	}
}
