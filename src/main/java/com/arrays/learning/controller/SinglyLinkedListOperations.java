package com.arrays.learning.controller;

import java.util.LinkedList;
import java.util.List;

public class SinglyLinkedListOperations<T> {
	
	public class Node {
		
		T data;
		Node nextNode;
	}
	
	Node headNode;
	int size;
	
	public SinglyLinkedListOperations() {
		this.headNode=null;
		this.size=0;
	}
	
	
	public void insertAtHead(T data) {
		
		Node newNode = new Node();
		newNode.data=data;
		newNode.nextNode=headNode;
		headNode=newNode;
		size++;
				
	}
	
	public boolean isEmpty() {
		
		return headNode==null;
	}
	
	public void printList() {
		
		if(isEmpty()) {
			System.out.println("List is Empty");
		}
		
		Node temp = this.headNode;
		System.out.print("List : ");
		while(temp.nextNode!=null) {
			System.out.print(temp.data.toString() + " -> ");
			temp = temp.nextNode;
		}
		System.out.println(temp.data.toString() + " -> null" );
	}
	
public void insertAtEnd(T data) {
	if(isEmpty()) {
		insertAtHead(data);
		return;
	}
	
	Node lastNode= headNode;
	while(lastNode.nextNode!=null) {
		lastNode = lastNode.nextNode;
	}
	Node newNode = new Node();
	newNode.data=data;
	lastNode.nextNode=newNode;
	newNode.nextNode=null;
	size++;
	
}
	



	
	
	

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.addLast("string");
		list.addFirst("Macho");
		System.out.println("List value is "+ list.toString());
		
		SinglyLinkedListOperations<String> obj = new SinglyLinkedListOperations<String>();
		obj.insertAtEnd("This");
		obj.insertAtEnd("is");
		obj.insertAtEnd("Test");
		obj.printList();
	}

}
