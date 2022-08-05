package com.walshfernandes.callable;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableImplementation implements Callable<String>{

	@Override
	public String call() throws Exception {
		Thread.sleep(2_000);
		
		return "Walsh";
	}

}
