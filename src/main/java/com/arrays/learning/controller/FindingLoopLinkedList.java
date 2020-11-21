package com.arrays.learning.controller;

public class FindingLoopLinkedList<T> {
	
	
	public class Node{
		
		T data;
		Node nextNode;
	}
	
	Node headNode;
	int size;
	
	public FindingLoopLinkedList() {
		
		this.headNode = null;
		this.size = 0;
	}
	
	public boolean checkLoop() {
		
		return true;
	}

}
