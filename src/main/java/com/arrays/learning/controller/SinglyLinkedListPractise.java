package com.arrays.learning.controller;

public class SinglyLinkedListPractise<T> {
	
	public class Node{
		
		public T data;
		
		public Node nextNode;
	}
	
	public Node headNode;
	public int size;
	
	public SinglyLinkedListPractise() {
		this.headNode = null;
		this.size = 0;
		
	}
	
	public boolean isEmpty() {
		return headNode ==null;
	}
	
	public void printList() {
		if(isEmpty()) {
			System.out.println("The list is empty");
		}
		System.out.print("List is : ");
		Node temp = headNode;
		while(temp.nextNode!=null) {
			System.out.print(temp.data.toString() + " -> ");
			temp = temp.nextNode;
		}
		System.out.println(temp.data.toString() + " -> null");
		
	}
	
	public void insertAtHead(T data) {
		
		Node newNode = new Node();
		newNode.data = data;
		newNode.nextNode = headNode;
		headNode=newNode;
		size++;
	}
	
	public void insertAtEnd(T data) {
		
		if(isEmpty()) {
			insertAtHead(data);
			return;
		}
		
		Node currentNode = headNode;
		
		while(currentNode!=null && currentNode.nextNode!=null) {
			currentNode = currentNode.nextNode;
		}
		
		Node newNode = new Node();
		newNode.data=data;
		currentNode.nextNode=newNode;
		newNode.nextNode=null;
		size++;
		
	}
	
	public void insertAfterValue(T data, T previousData) {
	
		Node currentNode = headNode;
		
		while(currentNode!=null && !currentNode.data.equals(previousData)) {
			currentNode=currentNode.nextNode;
		}
		//if such a node is found
		
		if(currentNode.data.equals(previousData)) {
			Node newNode = new Node();
			newNode.data = data;
			newNode.nextNode=currentNode.nextNode;
			currentNode.nextNode=newNode;
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
	
	public void deletebyValue(T data) {
		if(isEmpty()) {
			return;
		}
		Node currentNode = headNode;
		Node prevNode = headNode;
		
		while(currentNode!=null && !currentNode.data.equals(data)) {
			prevNode = currentNode;
			currentNode=currentNode.nextNode;
			
		}
		//if such a node is found
		if(currentNode!=null && currentNode.data.equals(data)) {
			prevNode.nextNode=currentNode.nextNode;
			size--;
		}
		
	}
	
	public boolean SearchbyValue(T data) {
		
		if(isEmpty()) {
			return false;
		}
		
		Node currentNode = headNode;
		while(currentNode!=null && !currentNode.data.equals(data)) {
			currentNode=currentNode.nextNode;
		}
		//if such a node is found,
		
		if(currentNode!=null && currentNode.data.equals(data)) {
			return true;
		}
		return false;
		
	}
	
	public Object findMiddleNode(SinglyLinkedListPractise<T> list) {
		
		if (isEmpty()) {
			return null;
		}
		
		SinglyLinkedListPractise.Node middle = list.headNode;
		SinglyLinkedListPractise.Node current = list.headNode;
		
		while(middle!=null && current!=null && current.nextNode!=null) {
			current = current.nextNode.nextNode;
					if(current!=null) {
						middle= middle.nextNode;
					}
		}
		
		
		
		return middle.data;
		
	}
	
	public static <T> void removeDuplicates(SinglyLinkedListPractise<T> list) {
		
		SinglyLinkedListPractise.Node currentNode = list.headNode; // outer loop
		SinglyLinkedListPractise.Node compareNode = null; //inner loop
		
		while(currentNode!=null && currentNode.nextNode!=null) {
			compareNode=currentNode;
			
			while(compareNode.nextNode!=null){
				if (currentNode.data.equals(compareNode.nextNode.data)) {
					//remove duplicates
					compareNode.nextNode =compareNode.nextNode.nextNode;
				}
				else {
					compareNode = compareNode.nextNode;
				}
			}
			currentNode = currentNode.nextNode;
		}
		
	}
	
	public static void main(String args[]) {
		
		SinglyLinkedListPractise<Integer> list = new SinglyLinkedListPractise<Integer>();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.insertAtEnd(6);
		list.printList();
		list.removeDuplicates(list);
		list.printList();
		Object testobject = list.findMiddleNode(list);
		System.out.println(testobject.toString());
		
		
		//SinglyLinkedListpractise1<String> obj1 = new SinglyLinkedListpractise1();
		//obj1.printList();
	}
	

}
