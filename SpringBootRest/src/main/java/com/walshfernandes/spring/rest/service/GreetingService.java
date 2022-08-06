package com.walshfernandes.spring.rest.service;

import com.walshfernandes.spring.rest.beans.Greeting;

public class GreetingService {
	public Greeting getGreeting(String name) {
		return new Greeting(name, String.format("Hello %s", name));
	}
}
