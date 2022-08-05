package com.walshfernandes.spring.rest.beans;

public class Greeting {
	private final String name;
	private final String message;
	
	public Greeting(String name, String message) {
		super();
		this.name = name;
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}
}
