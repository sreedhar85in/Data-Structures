package com.arrays.learning.controller;

public class SinglyLinkedListPractice4<T> {
	
	public class Node{
		
		T data;
		Node nextNode;
	}
	
	Node headNode;
	int size;
	
	public SinglyLinkedListPractice4() {
		this.headNode = null;
		this.size=0;
	}
	
	public boolean isEmpty() {
		return headNode==null;
	}
	
	public void printList() {
		
		if(isEmpty()) {
			System.out.println("The list is empty");
		}
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
