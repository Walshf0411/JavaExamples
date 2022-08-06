package com.walshfernandes.spring.rest.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.walshfernandes.spring.rest.beans.Greeting;

public class GreetingService {
	@Autowired
	private String format;
	
	public Greeting getGreeting(String name) {
		return new Greeting(name, String.format(format, name));
	}
}
