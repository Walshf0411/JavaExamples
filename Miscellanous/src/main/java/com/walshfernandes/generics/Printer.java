package com.walshfernandes.generics;

/*
 * Simple generics example, type parameter can be used in method
 * arguments, return types, esentially anywhere in the class
 * */
public class Printer<T> {
	T thingToPrint;
	
	public Printer(T thingToPrint) {
		this.thingToPrint = thingToPrint;
	}
	
	public void print() {
		System.out.println(thingToPrint);
	}
}
