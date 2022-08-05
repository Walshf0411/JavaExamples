package com.walshfernandes.spring.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.walshfernandes.spring.rest.beans.Greeting;

@RestController
public class GreetingController {
	
	@GetMapping("/greeting")
	public Greeting greetUser(@RequestParam("user") String user) {
		return new Greeting(user, "Hi user");
	}
}
