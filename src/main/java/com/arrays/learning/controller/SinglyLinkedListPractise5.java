package com.arrays.learning.controller;

public class SinglyLinkedListPractise5<T> {
	
	public class Node{
		
		T data;
		Node nextNode;
	}
	
	Node headNode;
	int size;
	
	public void SinglyLinkedListPractise5() {
		
		this.headNode = null;
		this.size=0;
	}
	
	
	public boolean isEmpty() {
		
		return headNode==null;
	}
	
	public void printList() {
		
		if(isEmpty()) {
			System.out.println("List is Empty");
		}
		
		System.out.print("List is : ");
		
		Node currentNode = headNode;
		
		while(currentNode.nextNode!=null) {
			System.out.print(currentNode.data.toString() + " -> ");
			currentNode = currentNode.nextNode;
		}
		System.out.println(currentNode.data.toString() + " -> null");
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
			insertAtHead(data);
			return;
		}
		
		Node currentNode = headNode;

		while(currentNode.nextNode!=null) {
			currentNode = currentNode.nextNode;
		}
		
		Node newNode = new Node();
		newNode.data=data;
		currentNode.nextNode=newNode;
		newNode.nextNode=null;
		size++;
	}
	
	public void insertAfterValue(T data, T previousData) {
		
		if(isEmpty()) {
			return ;
		}
		
		Node currentNode = headNode;
		
		while(currentNode!=null && !currentNode.data.equals(previousData)) {
			
			
			//
			currentNode = currentNode.nextNode;
		}
		
		if(currentNode.data.equals(previousData)){
			
			Node newNode = new Node();
			newNode.data=data;
			newNode.nextNode = currentNode.nextNode;
			currentNode.nextNode=newNode;
			size++;
			
			
		}
	}
	
	public void deleteAtHead() {
		
		headNode= headNode.nextNode;
		size--;
		
	}
	
	public void deleteByValue(T data) {
		
		
		Node currentNode =headNode;
		Node prevNode = headNode;
		
		while(currentNode!=null) {
			
			
			if(currentNode.data.equals(data)) {
				
				prevNode.nextNode = currentNode.nextNode;				
				size--;
				return;
				
				
			}
			
			prevNode = currentNode;
			currentNode = currentNode.nextNode;
			//
		}
		
		
	}
	
	public Object findMiddleNode(SinglyLinkedListPractise5 list) {
		
		Node currentNode = headNode;
		Node middleNode = headNode;
		
		while(middleNode!=null&& currentNode!=null&& currentNode.nextNode!=null) {
			
			currentNode = currentNode.nextNode.nextNode;
			
			
			if(currentNode!=null) {
				middleNode = middleNode.nextNode;
			}
		}
		
		return middleNode.data;
		
	}
	
	public void removeDuplicates(SinglyLinkedListPractise5 list) {
		
		SinglyLinkedListPractise5.Node currentNode = list.headNode;
		
		SinglyLinkedListPractise5.Node compareNode = null;
		
		while(currentNode!=null && currentNode.nextNode!=null) {
			
			compareNode = currentNode;
			
			while(compareNode.nextNode!=null) {
				
				//check if an duplicates
				
				if(currentNode.data.equals(compareNode.nextNode.data)) {
					
					compareNode.nextNode = compareNode.nextNode.nextNode;
					
					
				}
				
				else {
					
					compareNode = compareNode.nextNode;
				}
				
			}
			currentNode = currentNode.nextNode;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		SinglyLinkedListPractise5<String> obj1 = new SinglyLinkedListPractise5<String>();
		SinglyLinkedListPractise5<Integer> obj2 = new SinglyLinkedListPractise5<Integer>();
		SinglyLinkedListPractise5<Integer> obj3 = new SinglyLinkedListPractise5<Integer>();
		/*
		 * obj2.insertAtHead(1); obj2.insertAtHead(2); obj2.insertAtHead(3);
		 */
		obj2.insertAtEnd(1);
		obj2.insertAtEnd(2);
		obj2.insertAtEnd(3);
		obj2.printList();
		obj2.insertAfterValue(4, 2);
		obj2.printList();
		obj2.deleteAtHead();
		obj2.printList();
		obj2.deleteByValue(4);
		obj2.printList();
		obj3.insertAtEnd(1);
		obj3.insertAtEnd(2);
		obj3.insertAtEnd(3);
		obj3.insertAtEnd(4);
		obj3.printList();
		System.out.println(obj3.findMiddleNode(obj3));
		obj3.insertAtEnd(5);
		obj3.insertAtEnd(5);
		obj3.printList();
		obj3.removeDuplicates(obj3);
		obj3.printList();
		
		
		
	}
}
