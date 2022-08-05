package com.walshfernandes.callable;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableMain {
	public static void main(String args[]) throws Exception {
		Callable<String> callable = new CallableImplementation();
		
		ArrayList<FutureTask<String>> tasks = new ArrayList<>();
		tasks.add(new FutureTask<>(callable));
		tasks.add(new FutureTask<>(callable));
		
		for (FutureTask<String> task: tasks) {
			new Thread(task).start();
		}
		
//		while(true) {
//			boolean hasTaskNotCompleted = false;
//			for (FutureTask<String> task: tasks) {
//				if (!task.isDone()) hasTaskNotCompleted = true;
//			}
//			if (!hasTaskNotCompleted) break;
//			Thread.sleep(1000);
//		} 
		
		for (FutureTask<String> task: tasks) {
			System.out.println(task.get());
		}
	}
}
