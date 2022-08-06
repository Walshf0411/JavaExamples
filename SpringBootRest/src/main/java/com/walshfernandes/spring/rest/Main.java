package com.walshfernandes.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.walshfernandes.spring.rest.config.ConfigForApplication;
import com.walshfernandes.spring.rest.service.ByeService;
import com.walshfernandes.spring.rest.service.GreetingService;

/*
 * The @SpringBootApplication annotation is basically the same as
 * same as @Configuration @EnableAutoConfiguration @ComponentScan.
 * These 3 annotations are generally required by developers hence
 * it is the annotation
 * 
 * @EnableAutoConfiguration -> loads beans from the classpasth as well
 * */

//
@EnableAutoConfiguration
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
//		ctx.getBean(ByeService.class);
	}
}
