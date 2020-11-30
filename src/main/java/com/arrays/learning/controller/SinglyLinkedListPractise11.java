package com.arrays.learning.controller;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

public class SinglyLinkedListPractise11<T> {

	public class Node {
		T data;

		Node nextNode;
	}

	private Node headNode;
	private int size;

	public Node getHeadNode() {
		return headNode;
	}

	public void setHeadNode(Node headNode) {
		this.headNode = headNode;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public SinglyLinkedListPractise11() {
		
		this.headNode = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		
		return headNode==null;
	}
	
	public void printList() {
		
		if(isEmpty()) {
			System.out.println("List is Empty");
		}
		
		System.out.print("List is : ");
		
		Node currentNode = this.headNode;
		
		while(currentNode.nextNode!=null) {
			
			System.out.print(currentNode.data.toString() + " -> ");
			currentNode = currentNode.nextNode;
		}
		
		System.out.println(currentNode.data.toString() + "-> null");
	}
	
	public void insertAtHead(T data) {
		
		Node newNode = new Node();
		newNode.data = data;
		newNode.nextNode = headNode;
		headNode = newNode;
		size++;
		
	}
	
	public void insertATEnd(T data) {
		
		if(isEmpty()) {
			insertAtHead(data);
			return;
		}
		
		Node currentNode = this.headNode;
		
		while(currentNode.nextNode!=null) {
			currentNode = currentNode.nextNode;
		}
		
		Node newNode = new Node();
		newNode.data = data;
		newNode.nextNode = null;
		currentNode.nextNode = newNode;
		size++;
	}
	
	public void insertAfterValue(T data, T previousData) {
		
		Node currentNode = this.headNode;
	
		
		while(currentNode!=null) {
			
			if(currentNode.data.equals(previousData)) {
				
				Node newNode = new Node();
				newNode.data=data;
				
				newNode.nextNode = currentNode.nextNode;
				currentNode.nextNode = newNode;
				size++;
				
				
			}
			
			currentNode = currentNode.nextNode;
		}
	}
	
	public void deleteAtHead() {
		
		if(isEmpty()) {
		
			return;
		}
		headNode = headNode.nextNode;
		size--;
		
	}
	
	public void deleteAtEnd() {
		
		if(isEmpty()) {
			
			return;
		}
		
		Node currentNode = this.headNode;
		Node prevNode = this.headNode;
		
		while(currentNode.nextNode!=null) {
			
			prevNode = currentNode;
			currentNode = currentNode.nextNode;
		}
		
		prevNode.nextNode = null;
		size--;
		
		
	}
	
	public void deleteByValue(T data) {
		
		if(isEmpty()) {
			
			return;
		}
		
		Node currentNode = this.headNode;
		Node prevNode = this.headNode;
		
		while(currentNode!=null) {
			
			if(currentNode.data.equals(data)) {
				
				prevNode.nextNode = currentNode.nextNode;
				size--;
				return;
				
			}
			
			prevNode = currentNode;
			currentNode = currentNode.nextNode;
		}
		
		
	}
	
	public void reverse(SinglyLinkedListPractise11<T> list1) {
		
		SinglyLinkedListPractise11<T>.Node next = null;
		SinglyLinkedListPractise11<T>.Node current = list1.getHeadNode();
		SinglyLinkedListPractise11<T>.Node prev = null;
		
		while(current!=null) {
			next = current.nextNode;
			current.nextNode = prev;
			prev = current;
			current = next;
			
		}
		list1.headNode = prev;
	}
	
	
	public boolean detectLoop(SinglyLinkedListPractise11<T> list1) {
		
		Node fast = list1.getHeadNode();
		Node slow = list1.getHeadNode();
		
		while(slow!=null && fast!=null && fast.nextNode!=null) {
			
			fast = fast.nextNode.nextNode;
			slow = slow.nextNode;
			
			if(fast ==slow) {
				return true;
			}
			
		}
		return false;
		
		
	}
	
	public Object findMiddle(SinglyLinkedListPractise11<T> list1) {
		
		SinglyLinkedListPractise11<T>.Node middleNode = list1.getHeadNode();
		SinglyLinkedListPractise11<T>.Node currentNode = list1.getHeadNode();
		
		while(middleNode!=null&& currentNode!=null && currentNode.nextNode!=null) {
			
			currentNode = currentNode.nextNode.nextNode;
			
			if(currentNode!=null) {
				middleNode = middleNode.nextNode;
			}
		}
		
		return middleNode.data;
	}
	
	public static <T> boolean contains(SinglyLinkedListPractise11<T> list1, T data) {
		
		SinglyLinkedListPractise11<T>.Node currentNode = list1.getHeadNode();
		
		while(currentNode!=null) {
			
			if(currentNode.data.equals(data)) {
				return true;
			}
			
			currentNode = currentNode.nextNode;
			
		}
		return false;
		
		
	}
	
	public static <T> SinglyLinkedListPractise11<T> union(SinglyLinkedListPractise11<T> list1, SinglyLinkedListPractise11<T> list2){
		
		
		
		if(list1.isEmpty()) {
			return list2;
		}
		

		if(list2.isEmpty()) {
			return list1;
		}
		
		SinglyLinkedListPractise11<T>.Node currentNode = list1.getHeadNode();
		
		while(currentNode.nextNode!=null) {
			currentNode = currentNode.nextNode;
		}
		
		currentNode.nextNode = list2.getHeadNode();
		return list1;
		
	}
	
	//
	
	
	public static <T> SinglyLinkedListPractise11<T> intersection(SinglyLinkedListPractise11<T> list1, SinglyLinkedListPractise11<T> list2){
		
		SinglyLinkedListPractise11<T> result = new SinglyLinkedListPractise11<T>();
		
		if(list1.isEmpty()||list2.isEmpty()) {
			return null;
		}
		
		SinglyLinkedListPractise11<T>.Node currentNode = list1.headNode;
		
		while(currentNode!=null) {
			
			if(contains(list2, currentNode.data)) {
				result.insertAtHead(currentNode.data);
			}
			currentNode = currentNode.nextNode;
		}
		
		return result;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
