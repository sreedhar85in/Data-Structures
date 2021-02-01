package com.arrays.learning.controller;

public class CloningLinkedList<T> {
	
	public class Node{
		
		T data;
		Node nextNode;
		
	}
	
	int size;
	Node headNode;
	
	public CloningLinkedList() {
		
		this.size = 0;
		this.headNode = null;
		
	}
	
	public boolean isEmpty() {
		
		return headNode==null;
	}
	
	public void insertAtHead(T data) {
		
		Node newNode = new Node();
		newNode.data = data;
		newNode.nextNode = headNode;
		size++;
	}
	
	
	

}
