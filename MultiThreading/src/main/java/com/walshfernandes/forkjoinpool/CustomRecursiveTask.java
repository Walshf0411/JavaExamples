package com.walshfernandes.forkjoinpool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class CustomRecursiveTask extends RecursiveTask<Integer>{

	private static final Logger logger = Logger.getAnonymousLogger();
	private static final int THRESHOLD = 4;
	private final Integer array[];
	
	public CustomRecursiveTask(final Integer array[]) {
		this.array = array; 
	}
	
	@Override
	protected Integer compute() {
		if (array.length > THRESHOLD) {
			return ForkJoinTask.invokeAll(createSubTasks())
						.stream()
						.mapToInt(ForkJoinTask::join)
						.sum();
		} else {
			return sumArray();
		}
	}

	private List<CustomRecursiveTask> createSubTasks(){
		List<CustomRecursiveTask> subTasks = new ArrayList<>();
		
		Integer part1[] = Arrays.copyOfRange(array, 0, array.length / 2);
		Integer part2[] = Arrays.copyOfRange(array, array.length / 2, array.length);
		
		subTasks.add(new CustomRecursiveTask(part1));
		subTasks.add(new CustomRecursiveTask(part2));
		
		return subTasks;
	}
	
	private int sumArray() {
		int sum = Arrays.stream(array).mapToInt(x -> x).sum();
		logger.info("This result - (" + sum + ") - was processed by " 
		          + Thread.currentThread().getName());
		return sum;
	}
}
