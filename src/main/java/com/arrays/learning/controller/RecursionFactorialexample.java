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
	
	StringBuffer test = new StringBuffer();
	for(int i=9;i>=0;i--){
		
		test.append(i+" ");
       
    }
	
	 System.out.println(test );
	 String yourString = "@catDog_#3";
	 
	 String result1 = yourString.replaceAll("[\\@\\+\\_ \\#:,]","");
	 System.out.println(result1);
}

}
