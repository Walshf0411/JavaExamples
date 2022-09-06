package com.walshfernandes.forkjoinpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class ForkJoinPool2Main {
	
	private static final Logger logger = Logger.getAnonymousLogger();
	
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		ForkJoinPool pool = ForkJoinPool.commonPool();
		
//		pool.submit(() -> System.out.println("asdas")); // Runnable
//		ForkJoinTask<String> callableTask = pool.submit(() -> "Walsh"); // Callable
//		ForkJoinTask<String> runnableTask2 = pool.submit(() -> {
//			try {
//				logger.info("Sleeping....");
//				Thread.sleep(2000);
//				logger.info("Running....");	
//			} catch(InterruptedException e) {}
//		}, "walsh"); // Runnable with predefined result
//		
//		System.out.println(callableTask.get());
//		logger.info(runnableTask2.get());
//		logger.info("Got output from runnableTask2");
		
//		RecursiveAction recursiveAction = new CustomRecursiveAction(generateRandomString(100));
//		pool.submit(recursiveAction).get();
		
//		RecursiveTask<Integer> recursiveTask = new CustomRecursiveTask(generateRandomArray(100));
//		logger.info("Final sum: " + pool.submit(recursiveTask).get());
	}
	
	private static String generateRandomString(int length) {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
		          +"lmnopqrstuvwxyz!@#$%&";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
	
	private static Integer[] generateRandomArray(int length) {
		List<Integer> integers = new ArrayList<>();
		IntStream.generate(() -> (int)(Math.random() * 10)).limit(length).forEach(x -> integers.add(x));
		
		return integers.toArray(new Integer[0]);
	}
}
