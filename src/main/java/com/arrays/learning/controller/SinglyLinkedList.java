package com.arrays.learning.controller;

import springfox.documentation.service.Header;

public class SinglyLinkedList<T> {
	
	public class Node{
		T data;
		Node nextNode;
		
	}
	
	Node headNode;
	int size;
	
	public SinglyLinkedList() {
		headNode=null;
		size=0;
	}
	
	public boolean isEmpty() {
		
		return headNode==null;
	}
	
	public void printList() {
		
		if(isEmpty()) {
			System.out.println("THe List is Empty");
		}
		
		System.out.print(" List : ");
		Node temp = headNode;
		while(temp.nextNode!=null) {
			System.out.print(temp.data.toString() + " -> ");
			temp=temp.nextNode;
		}
		System.out.print(temp.data.toString()+ " -> null");
		
	}
	
	public void insertAtHead(T data) {
		
		Node newNode = new Node();
		newNode.data=data;
		newNode.nextNode=headNode;
		headNode=newNode;
		size++;
	}
	
	public void insertAtEnd(T data) {
		
		
		if(isEmpty()) {
			//insert at head
			insertAtHead(data);
			return;
		}
		Node lastNode = headNode;
		while(lastNode.nextNode!=null) {
			lastNode = lastNode.nextNode;
		}
		
		Node newNode = new Node();
		newNode.data=data;
		lastNode.nextNode = newNode;
		newNode.nextNode=null;
		size++;
		
	}
	
	public void insertAfter(T data, T previousNode) {
		Node newNode = new Node();
		newNode.data=data;
		//assign headnode for traversal
		Node currentNode = headNode;
		
		while(currentNode!=null && !currentNode.data.equals(previousNode)) {
			currentNode = currentNode.nextNode;
		}
		//if such a node is found
		if(currentNode.data.equals(previousNode)) {
			newNode.nextNode=currentNode.nextNode;
			currentNode.nextNode=newNode;
			size++;
		}
	}
	
	public void deleteAtHead() {
		if(isEmpty()){
			return;
		}
		headNode=headNode.nextNode;
		size--;
	}
	public void deleteByValue(T data) {
	
		if (isEmpty()) {
			return;
		}
		
		Node currentNode = headNode;
		Node prevNode = null;
		
		if(currentNode.data.equals(data)) {
			deleteAtHead();
			return;
		}
		
		
		
		while(currentNode!=null&& !currentNode.data.equals(data)) {
			prevNode = currentNode;
			currentNode = currentNode.nextNode;
		}
		
		if(currentNode.data.equals(data)) {
			prevNode.nextNode=currentNode.nextNode;
			size--;
			
		}
	}
	
	public boolean searchValue(T data) {
		
		if(isEmpty()) {
			return false;
		}
		Node tempNode = headNode;
				
		while(tempNode!=null ) {
			//if node is found
			if (tempNode.data.equals(data)) {
			return true;
			}
//if not found, iterate the rest of the nodes one by one
			tempNode = tempNode.nextNode;
		}
		
		return false;
	}
	
	public Object findMiddle(SinglyLinkedList<T> list) {
		
		if(list.isEmpty()) {
			return null;
		}
		
		SinglyLinkedList.Node middle = list.headNode;
		SinglyLinkedList.Node current = list.headNode;
		while(middle!=null && current!=null && current.nextNode!=null ) {
			current = current.nextNode.nextNode;
			
			if(current!=null) {
				middle = middle.nextNode; 
			}
		}
		return middle.data;
		
	}
	
	public static <T> void removeDuplicates(SinglyLinkedList<T> list) {
		
		SinglyLinkedList.Node currentNode = list.headNode; // will be used for outer loop
		SinglyLinkedList.Node compareNode = null; //will be used for inner loop.
		
		while(currentNode!=null && currentNode.nextNode!=null ) {
			compareNode = currentNode;
			
			while(compareNode.nextNode!=null) {
				if(currentNode.data.equals(compareNode.nextNode.data)) {
					//check if duplicate
					compareNode.nextNode=compareNode.nextNode.nextNode;
				}
				
				else {
					compareNode = compareNode.nextNode;
				}
			}
			currentNode = currentNode.nextNode;
			
			
					
		}
		
		
	}

	public static void main(String[] args) {

		SinglyLinkedList<String> obj1 = new SinglyLinkedList<String>();
		/*
		 * obj1.insertAtHead("Test"); obj1.insertAtHead("a"); obj1.insertAtHead("is");
		 * obj1.insertAtHead("This"); obj1.printList();
		 */
		obj1.insertAtEnd("This");
		obj1.insertAtEnd("This");
		obj1.insertAtEnd("is");
		obj1.insertAtEnd("a");
		obj1.insertAtEnd("Test");
		obj1.insertAfter("random", "is");
		//obj1.deleteAtHead();
		//obj1.deleteByValue("This");
		obj1.printList();
		System.out.println("The value of the middle node is : "+obj1.findMiddle(obj1));
		obj1.removeDuplicates(obj1);
		obj1.printList();
		//System.out.println("");
		//System.out.println("The value of search boolean is : " + obj1.searchValue("Test"));
	}

}
