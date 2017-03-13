package com.springtut.factory;

import org.slf4j.Logger;

public class LogFactory {

	private Logger logger;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
}
