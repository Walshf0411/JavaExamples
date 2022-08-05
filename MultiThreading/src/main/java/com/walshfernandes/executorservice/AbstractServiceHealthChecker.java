package com.walshfernandes.executorservice;

import java.util.concurrent.CountDownLatch;

public abstract class AbstractServiceHealthChecker implements Runnable {
	protected CountDownLatch latch;
	
	public AbstractServiceHealthChecker(CountDownLatch latch) {
		this.latch = latch;
	}
	public abstract void checkHealth() throws InterruptedException;
	public abstract String getServiceName();
	
	@Override
	public void run() {
		try {
			System.out.println("Checking health for service " + getServiceName());
			checkHealth();
			latch.countDown();
			System.out.println("Service " + getServiceName() + " is up");
		} catch(InterruptedException e) {
			System.out.println("Sleep interrupted");
		}
	}
}
