package com.arrays.learning.controller;

public class Recursion {

	
	public static void main(String[] args) {
		
		
	}
	
	
	public int testRecursion(int value) {
		
		if (value<5) {
			return value+1;
		}
		else {
			
			return value;
		}
		//testRecursion(value-1);
		
	}
	
	
public void testRecursionAnother(int value) {
		
		if (value<5)
			//return value+2;

		testRecursionAnother(value-1);
		System.out.println();
	
}
}