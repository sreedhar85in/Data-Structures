package com.arrays.learning.controller;

public class SinglyLinkedListPractise4<T> {
	
	public class Node{
		
		
		T data;
		Node nextNode;
		
	}
	
	Node headNode;
	int size;
	
	public SinglyLinkedListPractise4() {
		this.headNode = null;
		this.size=0;
	}
	
	public boolean isEmpty() {
		return headNode==null;
	}
	
	public void printList() {
		
		if(isEmpty()) {
			System.out.println("List is Empty");
			return;
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
		newNode.data = data;
		newNode.nextNode = headNode;
		headNode = newNode ;
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
	
	public void insertAfter(T data, T previousData) {
		
		if(isEmpty()) {
			insertAtHead(data);
			return;
		}
		Node currentNode = headNode;
		
		
		while(currentNode!=null && !currentNode.data.equals(previousData)) {
			
			currentNode= currentNode.nextNode;
		}
		
		if(currentNode!=null && currentNode.data.equals(previousData)) {
			Node newNode = new Node();
			newNode.data=data;
			newNode.nextNode = currentNode.nextNode;
			currentNode.nextNode= newNode;
			size++;
		}
		
		
	}
	
	public void deleteAtHead() {
		if(isEmpty()) {
			return;
		}
		headNode = headNode.nextNode;
		size--;
	}
	
	public void deleteByValue(T data) {
		if(isEmpty()) {
			return;
		}
		Node currentNode = headNode;
		Node previousNode = null;
		
		while(currentNode!=null && !currentNode.data.equals(data)) {
			previousNode = currentNode;
			currentNode = currentNode.nextNode;
		}
		
		if(currentNode!=null && previousNode!=null && currentNode.data.equals(data)) {
			
			previousNode.nextNode = currentNode.nextNode;
			size--;
		}
	}
	
	public  Object findMiddleNode(SinglyLinkedListPractise4 list) {
		Node currentNode = list.headNode;
		Node middleNode = list.headNode;
		
		while(middleNode!=null && currentNode!=null && currentNode.nextNode!=null) {
			
			currentNode= currentNode.nextNode.nextNode;
			
			if(currentNode!=null) {
				middleNode=middleNode.nextNode;
			}
		}
		
		
		return middleNode.data.toString();
		}
	
	public void removeDuplicates(SinglyLinkedListPractise4 list) {
		SinglyLinkedListPractise4.Node currentNode = list.headNode;
		SinglyLinkedListPractise4.Node compareNode = list.headNode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SinglyLinkedListPractise4<Integer> obj = new SinglyLinkedListPractise4<Integer>();
		obj.printList();
		obj.insertAtHead(1);
		obj.insertAtHead(2);
		obj.insertAtHead(3);
		obj.insertAtHead(4);
		obj.insertAtHead(5);
		obj.insertAtHead(6);
		obj.insertAtHead(7);
		
		obj.printList();
		System.out.println("The middle node is : " +obj.findMiddleNode(obj) );
		SinglyLinkedListPractise4<String> obj2 = new SinglyLinkedListPractise4<String>();
		obj2.printList();
		obj2.insertAtEnd("This");
		obj2.insertAtEnd("is");
		obj2.insertAtEnd("a");
		obj2.insertAtEnd("Test");
		
		obj2.printList();
		obj2.insertAfter("final", "is");
		obj2.printList();
		obj2.deleteByValue("final");
		obj2.printList();
		
	}

}
