package com.walshfernandes.generics;

import java.util.List;

/*
 * Example of using wildcards
 * Difference between generics & wildcards
 * https://stackoverflow.com/questions/10943137/difference-between-generic-type-and-wildcard-type
 * */
public class AnotherNumberPrinter {
	
	public void print(List<?> numbersToPrint) {
		numbersToPrint.forEach(System.out::println);
	}
}
