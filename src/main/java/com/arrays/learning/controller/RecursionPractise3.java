package com.arrays.learning.controller;

public class RecursionPractise3 {
	public static void main(String[] args) {
		
		int test = fun(16);
		System.out.println(test);
	}
	static int fun(int n) {
		
		if(n==1)
			return 0;
		
		else 
			return 1+ fun(n/2);
	}

}

//In general the answer is always log base two of n.


