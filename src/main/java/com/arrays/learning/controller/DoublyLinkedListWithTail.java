package com.arrays.learning.controller;

public class DoublyLinkedListWithTail<T> {
	
	
	public class Node{
		
		public T data;
		public Node nextNode;
		public Node prevNode;
		
	}
	
	//member variables
	
	public Node headNode;
	public Node tailNode;
	public int size;
	
	//constructor
	
	public DoublyLinkedListWithTail() {
		this.headNode=null;
		this.tailNode=null;
		this.size=0;
	}
	
	public boolean isEmpty() {
		//checking tail node to make sure.
		if(headNode==null  && tailNode ==null) {
			return true;
		}
		
		else {
			return false;
		}
	}

}
