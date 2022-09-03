package com.walshfernandes.spring.rest;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.walshfernandes.spring.rest.beans.User;
import com.walshfernandes.spring.rest.config.ConfigForApplication;
import com.walshfernandes.spring.rest.service.UserService;

/*
 * The @SpringBootApplication annotation is basically the same as
 * same as @Configuration @EnableAutoConfiguration @ComponentScan.
 * These 3 annotations are generally required by developers hence
 * it is the annotation
 * 
 * @EnableAutoConfiguration -> loads beans from the classpasth as well
 * */
@SpringBootApplication
public class Main {
	public static void main(String args[]) {
		// String spring boot application, web service
		// used to start web application
		SpringApplication.run(Main.class);
		
		// MAnually creating context
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//		ctx.register(ConfigForApplication.class);
//		ctx.refresh();
//		
//		UserService userService = ctx.getBean(UserService.class);
//		userService.createUser(new User("walsh", 24));
//		
//		userService.getUsers(Optional.ofNullable("walsh"), Optional.ofNullable(24))
//			.stream()
//			.forEach(e->System.out.println(e.getName() + " - " + e.getAge()));
	}
}
