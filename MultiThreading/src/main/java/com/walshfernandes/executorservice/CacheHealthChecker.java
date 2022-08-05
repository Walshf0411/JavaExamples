package com.walshfernandes.executorservice;

import java.util.concurrent.CountDownLatch;

public class CacheHealthChecker extends AbstractServiceHealthChecker {

	public CacheHealthChecker(CountDownLatch latch) {
		super(latch);
	}

	@Override
	public void checkHealth() throws InterruptedException {
		Thread.sleep(2000);
	}

	@Override
	public String getServiceName() {
		return "Cache"; 
	}

}
