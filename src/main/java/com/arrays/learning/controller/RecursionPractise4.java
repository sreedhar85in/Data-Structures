package com.arrays.learning.controller;

public class RecursionPractise4 {
	public static void main( String[] args) {
		
		fun(7);
	}
	
	public static void fun(int n) {
		
		
		if (n==0)
			return;
		
		fun (n/2);
		System.out.println(n%2);
	}

}
