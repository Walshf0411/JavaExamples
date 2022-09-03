package com.walshfernandes.generics;

/*
 * Generic method
 * type parameter comes between access specifier and return type.
 * */
public class AnotherPrinter {
	public <T>void print(T thingToPrint) {
		System.out.println(thingToPrint);
	}
}
