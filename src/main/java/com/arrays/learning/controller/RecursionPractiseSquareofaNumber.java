package com.arrays.learning.controller;

public class RecursionPractiseSquareofaNumber {
	private static int square(int n) {
		
		if(n==0) {
			return 0;
		}
		
		else {
			//(a-b)2 = a2 -2ab+b2
			//(n-1)2 = n2-2n+1
			//n2=(n-1)2+2n-1;
			return square(n-1) + (2*n)-1;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int input = 7;
		int output = square(input);
		System.out.println("The square of the number "+ input + " is" + output);

	}

}
