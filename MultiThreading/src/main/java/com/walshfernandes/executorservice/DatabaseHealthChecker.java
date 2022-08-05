package com.walshfernandes.executorservice;

import java.util.concurrent.CountDownLatch;

public class DatabaseHealthChecker extends AbstractServiceHealthChecker {

	public DatabaseHealthChecker(CountDownLatch latch) {
		super(latch);
	}

	@Override
	public void checkHealth() throws InterruptedException {
		Thread.sleep(1000);
	}

	@Override
	public String getServiceName() {
		return "DB";
	}

}
