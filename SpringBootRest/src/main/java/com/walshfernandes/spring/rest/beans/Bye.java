package com.walshfernandes.spring.rest.beans;

public class Bye {
	private final String name;
	private final String message;
	
	public Bye(String name, String message) {
		this.name = name;
		this.message = message;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getMessage() {
		return this.message;
	}
}
