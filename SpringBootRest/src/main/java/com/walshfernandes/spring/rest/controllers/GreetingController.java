package com.walshfernandes.spring.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.walshfernandes.spring.rest.beans.Greeting;
import com.walshfernandes.spring.rest.service.GreetingService;

@RestController
public class GreetingController {
	@Autowired
	private GreetingService greetingService;
	
	@GetMapping("/greeting")
	public Greeting greetUser(@RequestParam("user") String user) {
		return greetingService.getGreeting(user);
	}
}
