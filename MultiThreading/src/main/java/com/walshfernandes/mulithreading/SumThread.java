package com.walshfernandes.mulithreading;

/*
Problem Definition:
WAP to find the sum of an array using 4 threads.
*/
/**
* This thread finds the sum of a subsection of an array.
*/
public class SumThread extends Thread {
	private int lo, hi;
	private int[] arr;
	private int ans = 0;
	
	public SumThread(int[] arr, int lo, int hi) {
	    this.lo = lo;
	    this.hi = hi;
	    this.arr = arr;
	}
	
	@Override
	public void run() {
	    for (int i = lo; i < hi; i++) {
	        ans += arr[i];
	    }
	}
	
	public int getAns() {
		return ans;
	}
}