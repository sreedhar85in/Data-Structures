package com.arrays.learning.controller;

import java.util.*;

public class AcceptDoubleInput {

static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
  
  int n = 0;
  int a;
  int b;
  int v;
  
  System.out.print("Enter an integer greater than zero: ");
  if (sc.hasNextInt()) {
  n = sc.nextInt();
  }
  
  if (sc.hasNextDouble()) {
	  
	  n = (int) sc.nextDouble();
  }
    
  System.out.print("Enter two integer values a and b, where a < b: ");
  a = sc.nextInt();
  b = sc.nextInt();
  
  int i;
  
  System.out.println("Enter " + n + " integer values to check.");
  
  for (i = 0; i < n; i++) {
     System.out.print("Enter a value: ");
     v = sc.nextInt();
     
     if (v % a == 0 || v % b == 0)
        System.out.println("value " + v + " is valid.");
        
     else
        System.out.println("value " + v + " is not valid.");
  }
  }
  }