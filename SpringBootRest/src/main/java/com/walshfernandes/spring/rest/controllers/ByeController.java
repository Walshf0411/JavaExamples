package com.walshfernandes.spring.rest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.walshfernandes.spring.rest.beans.Bye;

/*
 * Here as we have used Controller we have to specify @ResponseBody 
 * annotation on the return type, so that spring knows that it has
 * to return a body(json) and not a view
 * */
@Controller
public class ByeController {
	
	@GetMapping("/bye")
	public @ResponseBody Bye doBye(@RequestParam("user") String user) {
		return new Bye(user, "Bye");
	}
}
