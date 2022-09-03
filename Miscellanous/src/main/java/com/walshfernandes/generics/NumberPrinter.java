package com.walshfernandes.generics;

import java.util.ArrayList;
import java.util.List;

/*
 * Example for bounded generics
 * 
 * We can also bound the class by multiple types
 * eg. public class NumberPrinter<T extends className & interfaceName>
 * */
public class NumberPrinter<T extends Number> {
	private List<T> numbersToAdd = new ArrayList<>();
	
	public NumberPrinter(List<T> numbersToAdd) {
		this.numbersToAdd.addAll(numbersToAdd);
	}
	
	public void print() {
		this.numbersToAdd.forEach(System.out::println);
	}
}