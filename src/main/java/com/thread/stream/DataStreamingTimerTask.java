package com.thread.stream;

import java.util.Calendar;
import java.util.concurrent.ExecutionException;

import org.kaaproject.kaa.client.DesktopKaaPlatformContext;
import org.kaaproject.kaa.client.Kaa;
import org.kaaproject.kaa.client.KaaClient;
import org.kaaproject.kaa.client.SimpleKaaClientStateListener;
import org.kaaproject.kaa.client.exceptions.KaaRuntimeException;
import org.kaaproject.kaa.client.logging.DefaultLogUploadStrategy;
import org.kaaproject.kaa.client.logging.LogStorageStatus;
import org.kaaproject.kaa.client.logging.LogUploadStrategyDecision;
import org.kaaproject.kaa.client.logging.RecordInfo;

import com.entity.schema.RecordData;
import com.springtut.utilities.LogUtils;

public class DataStreamingTimerTask extends Thread {
	
	private static KaaClient kaaClient;
	
	public DataStreamingTimerTask() {
		// TODO Auto-generated constructor stub
		try {
			if (kaaClient == null) {
				kaaClient = Kaa.newClient(new DesktopKaaPlatformContext(), new SimpleKaaClientStateListener(), true);
				kaaClient.setLogUploadStrategy(new DefaultLogUploadStrategy() {
					@Override
					public LogUploadStrategyDecision isUploadNeeded(LogStorageStatus status) {
						// TODO Auto-generated method stub
						if (status.getRecordCount() >= 1) {
							return LogUploadStrategyDecision.UPLOAD;
						}
						return LogUploadStrategyDecision.NOOP;
					}
				});
			}
		} catch (KaaRuntimeException e) {
			// TODO Auto-generated catch block
			LogUtils.getInstance().error(e);
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		kaaClient.start();
		sendDataToServer();
	}
	
	@Override
	public void interrupt() {
		// TODO Auto-generated method stub
		super.interrupt();
		if(kaaClient != null) kaaClient.stop();
	}
	
	public void sendDataToServer() {
		RecordData record = new RecordData();
		record.setId(1);
		record.setTemp(String.valueOf(Calendar.getInstance().getTime().getTime()));
		try {
			RecordInfo recordInfo = kaaClient.addLogRecord(record).get();
			System.out.println("Data delivery in " + recordInfo.getRecordDeliveryTimeMs() + " ms");
			if(record != null) sendDataToServer();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			kaaClient.stop();
			e.printStackTrace();
		}
	}

}