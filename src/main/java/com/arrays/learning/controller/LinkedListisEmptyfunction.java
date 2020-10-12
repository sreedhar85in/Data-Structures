package com.arrays.learning.controller;

import java.util.LinkedList;

public class LinkedListisEmptyfunction<T> {

	public class Node{
		
		public T data;
		public Node nextNode;
		
	}
	
	public Node headNode;
	public int size;
	//LinkedList test = new LinkedList();
	//constructor
	
	public LinkedListisEmptyfunction() {
		headNode=null;
		size=0;
		
	}
	
	public  boolean isEmpty() {
		
		if (headNode == null) {
			return true;
		}
		else {
			return false;
		}
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListisEmptyfunction obj = new LinkedListisEmptyfunction();
		boolean test =obj.isEmpty();
		System.out.println("the value of the boolean is :" + test);
	}

}
