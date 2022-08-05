package com.walshfernandes.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceMain {
	public static void main(String args[]) throws InterruptedException {
		System.out.println("Simulating multiple service check using executor service");
		CountDownLatch latch = new CountDownLatch(2);
		final List<AbstractServiceHealthChecker> healthCheckers = new ArrayList<>();
		healthCheckers.add(new DatabaseHealthChecker(latch));
		healthCheckers.add(new CacheHealthChecker(latch));
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		for (AbstractServiceHealthChecker healthChecker: healthCheckers) {
			service.execute(healthChecker);
		}
		latch.await();
		System.out.println("All services are up");
		service.shutdown();
	}
}
