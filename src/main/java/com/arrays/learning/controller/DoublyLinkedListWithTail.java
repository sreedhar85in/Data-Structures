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
	
	public Node getHeadNode() {
		return headNode;
	}

	public void setHeadNode(Node headNode) {
		this.headNode = headNode;
	}

	public Node getTailNode() {
		return tailNode;
	}

	public void setTailNode(Node tailNode) {
		this.tailNode = tailNode;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

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
	
	public boolean isEmptyNew() {
		
		return headNode==null && tailNode ==null;
	}
	
	public void insertAtHeadWithTailNodeLogic(T data) {
		
		Node newNode = new Node();
		newNode.data = data;
		newNode.nextNode = this.headNode;
		newNode.prevNode = null;
		if(!isEmptyNew()) {
			headNode.prevNode=newNode;
		}
		else {
			tailNode= newNode;
			
		}
		this.headNode=newNode;
		size++;
	}
	
	public void insetAtEndwithTailNodeLogic(T data) {
		
		if(isEmpty()) {
			insertAtHeadWithTailNodeLogic(data);
			return;
		}
		
		// make a new node and assign the value to be inserted.
		Node newNode = new Node();
		newNode.data=data;
		newNode.nextNode=null; //It will be inserted at the end so next node will be null.
		tailNode.nextNode = newNode;
		tailNode = newNode;
		size++;
		
	}
	

}
