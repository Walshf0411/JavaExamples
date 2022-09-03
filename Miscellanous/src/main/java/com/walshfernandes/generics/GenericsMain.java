package com.walshfernandes.generics;

import java.util.Arrays;
import java.util.List;

public class GenericsMain {

	public static void main(String[] args) {
		// Generic class
		Printer<String> printer = new Printer<>("walsh");
		printer.print();
		
		// Bounded generic class		
		NumberPrinter<Integer> doublePrinter = new NumberPrinter<>(Arrays.asList(1, 2, 3));
		doublePrinter.print();
		
		// Generic method
		AnotherPrinter anotherPrinter = new AnotherPrinter();
		anotherPrinter.print("walsh");
		anotherPrinter.print(1);
		
		// Wildcards
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		AnotherNumberPrinter anotherNumberPrinter = new AnotherNumberPrinter();
		anotherNumberPrinter.print(numbers);
	}

}
