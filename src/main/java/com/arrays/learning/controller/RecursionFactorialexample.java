package com.arrays.learning.controller;

public class RecursionFactorialexample {
	//Recursive Function
	private static int factorial(int n) {
		
		if(n==1) {
			return 1;
		}
		
		else {
			
			return (n * factorial(n-1));
		}
		
	}
	
	
public static void main(String[] args) {
	//calling from main
	
	int result = factorial(5);
	System.out.println("Factorial of 5 is :"+ result);
}

}
