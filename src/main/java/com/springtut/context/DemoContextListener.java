package com.springtut.context;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.springtut.pool.JDBCConnectionPool;
import com.springtut.utilities.LogUtils;
import com.thread.stream.DataStreamingTimerTask;

public class DemoContextListener implements ServletContextListener {
	private Timer timer;
	private static DataStreamingTimerTask streaming;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.println("Context distroyed...");
		if(streaming != null) streaming.interrupt();
		if(timer != null) {
			timer.cancel();
		}
		LogUtils.getInstance().info("Context distroyed !");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		try {
//			JDBCConnectionPool.setupDataSource();
			LogUtils.getInstance().message("Init db completed !");
			
//			streaming = new DataStreamingTimerTask();
//			streaming.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
