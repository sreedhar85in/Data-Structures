package com.arrays.learning.controller;

public class RecursionPractise2 {

	
	public static void main(String[] args) {
		
		
		fun(3);
		
		
		
		
		
	}
	
	
	static void fun(int n) {
		
		if(n==0)
			return;
		
		fun(n-1);
		System.out.println(n);
		fun(n-1);
	}
	
}



