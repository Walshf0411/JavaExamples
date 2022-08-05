package com.walshfernandes.forkjoinpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

import com.walshfernandes.executorservice.AbstractServiceHealthChecker;
import com.walshfernandes.executorservice.CacheHealthChecker;
import com.walshfernandes.executorservice.DatabaseHealthChecker;

public class ForkJoinPoolMain {
	public static void main(String args[]) throws InterruptedException {
		System.out.println("Simulating multiple service check using fork join pool");
		CountDownLatch latch = new CountDownLatch(2);
		final List<AbstractServiceHealthChecker> healthCheckers = new ArrayList<>();
		healthCheckers.add(new DatabaseHealthChecker(latch));
		healthCheckers.add(new CacheHealthChecker(latch));
		
		ForkJoinPool pool = new ForkJoinPool();
		
		for (AbstractServiceHealthChecker healthChecker: healthCheckers) {
			pool.submit(healthChecker);
		}
		latch.await();
		System.out.println("All services are up");
		pool.shutdown();
	}
}
