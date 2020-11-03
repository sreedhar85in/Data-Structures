package com.arrays.learning.controller;

public class SinglyLinkedListpractise1<T> {
	
	public class Node{
		
		T data;
		Node nextNode;
	}
	
	Node headNode;
	int size;

	public SinglyLinkedListpractise1() {
		this.headNode=null;
		this.size=0;
	}
	
	public boolean isEmpty() {
		return headNode==null;
	} 
	
	public void insertAtHead(T data) {
		
		Node newNode = new Node();
		newNode.data = data;
		newNode.nextNode=headNode;
		headNode=newNode;
		size++;
	}
	
	public void insertAtEnd(T data) {
		//check if the list is empty
		if(isEmpty()) {
			
			insertAtHead(data);
			return;
		}
		
Node newNode = new Node();
newNode.data=data;

//ready for traversal

Node lastNode = headNode;

while(lastNode.nextNode!=null) {
	
	lastNode = lastNode.nextNode;
	
}
	lastNode.nextNode=newNode;
	newNode.nextNode=null;
		
	}
	
	public void insertAfterValue(T data, T previousData) {
		
		Node newNode = new Node();
		newNode.data=data;
		Node currentNode = headNode;
		
		while(currentNode!=null && !currentNode.data.equals(previousData)) {
			currentNode=currentNode.nextNode;
			
			}
		
		//if such a node is found,
		
		if(currentNode.data.equals(previousData)) {
			newNode.nextNode=currentNode.nextNode;
			currentNode.nextNode=newNode;
			size++;
		}
		
		}
	
	
	public void deleteATHead() {
		
		if(isEmpty()) {
			return;
		}
		
		headNode=headNode.nextNode;
		size--;
	}
	
	public void deleteByValue(T data) {
		if(isEmpty()) {
			return;
		}
		
		Node currentNode = headNode;
		Node prevNode = null;
		
		//if the value is at head
		
		if(currentNode.data.equals(data)) {
			deleteATHead();
			return;
		}
		
		while(currentNode!=null && !currentNode.data.equals(data)) {
			prevNode = currentNode;
			currentNode = currentNode.nextNode;
		}
		
		if(currentNode.data.equals(data)) {
			prevNode.nextNode=currentNode.nextNode;
			size--;
			
		}
		
	}
	
	public boolean OptimisedSearch(T data) {
		if(isEmpty()) {
			return false;
		}
		Node tempNode = headNode;
		
		while(tempNode!=null) {
			
			//if node is iis found,
			
			if(tempNode.data.equals(data)) {
				return true;
			}
			
			//if not found iterate the list
			tempNode = tempNode.nextNode;
			
			
		}
		return false;
	}
	
	public Object findMiddle(SinglyLinkedListpractise1<T> list) {
		if(list.isEmpty()) {
			return null;
		}
		
		SinglyLinkedListpractise1.Node middleNode = list.headNode;
		SinglyLinkedListpractise1.Node currentNode = list.headNode;
		
		while(middleNode!=null&& currentNode!=null && currentNode.nextNode!=null) {
			
			currentNode = currentNode.nextNode.nextNode;
			
			if(currentNode!=null) {
				middleNode=middleNode.nextNode;
			}
		}
	
	return middleNode.data;
	}
	
	public static <T> void removeDuplicates(SinglyLinkedListpractise1<T> list) {
		SinglyLinkedListpractise1<T>.Node currentNode = list.headNode; //will be used for outer loop.
		SinglyLinkedListpractise1<T>.Node compareNode = null; // will be used for inner loop.
		
		//outerloop
		while(currentNode!=null && currentNode.nextNode!=null) {
			
			compareNode=currentNode;
			
			//innerloop
			while(compareNode.nextNode!=null) {
				//check if duplicate
				if(currentNode.data.equals(compareNode.nextNode.data)){
					compareNode.nextNode=compareNode.nextNode.nextNode;
				}
				
				else {
					compareNode = compareNode.nextNode;
				}
			}
			
			//end of inner loop
			//after that increment the currentnode by one
			currentNode = currentNode.nextNode;
		}
	}
	
}

