package com.walshfernandes.spring.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.walshfernandes.spring.rest.beans.Bye;


/*
 * By marking this component as @Component, we dont require
 * to create a method which returns an object of this type
 * in the config class.
 * */

@Component
public class ByeService {
	@Autowired
	@Qualifier("byeMessageFormat") 
	private String format;
	
	public Bye getBye(String name) {
		return new Bye(name, String.format(format, name));
	}
}
