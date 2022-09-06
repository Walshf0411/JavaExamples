package com.walshfernandes.executorservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceMain {
	public static void main(String args[]) throws InterruptedException, ExecutionException {
//		System.out.println("Simulating multiple service check using executor service");
//		CountDownLatch latch = new CountDownLatch(2);
//		final List<AbstractServiceHealthChecker> healthCheckers = new ArrayList<>();
//		healthCheckers.add(new DatabaseHealthChecker(latch));
//		healthCheckers.add(new CacheHealthChecker(latch));
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		
//		for (AbstractServiceHealthChecker healthChecker: healthCheckers) {
//			service.execute(healthChecker);
//		}
//		
//		service.execute(()->System.out.println("Runnable "));
//		
//		Future<String> future = service.submit(() -> "Service run");
		
		List<Callable<Integer>> runnables = Arrays.asList(()->1/0, ()-> 2);
//		List<Future<Integer>> futures = service.invokeAll(runnables);
		
		Integer aFuture = service.invokeAny(runnables);
		System.out.println(aFuture);
		
//		latch.await();
//		System.out.println("All services are up");
		service.shutdown();
	}
}
