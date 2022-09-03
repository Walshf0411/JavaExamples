package com.walshfernandes.spring.rest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.walshfernandes.spring.rest.beans.User;
import com.walshfernandes.spring.rest.service.UserService;

@RestController("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/user/add")
	public User createUser(User user) {
		System.out.println("Creating user");
		System.out.println("USER NAME: " + user.getName());
		userService.createUser(user);
		return user;
	}
	
	@GetMapping("user/get")
	public List<User> getUsers() {
		Optional<String> name = Optional.ofNullable(null);
		Optional<Integer> age = Optional.ofNullable(null);
		return userService.getUsers(name, age);
	}
}
