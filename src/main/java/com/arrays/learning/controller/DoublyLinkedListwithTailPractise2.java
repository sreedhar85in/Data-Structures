package com.arrays.learning.controller;

public class DoublyLinkedListwithTailPractise2<T> {

	public class Node {

		T data;
		Node nextNode;
		Node prevNode;
	}

	Node headNode;
	Node tailNode;
	int size;

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
	
	public DoublyLinkedListwithTailPractise2() {
		
		this.headNode = null;
		this.tailNode = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		
		return headNode==null && tailNode == null;
	}
	
	
	public void printList() {
		
		if(isEmpty()) {
			System.out.println("The List is Empty!");
			return;
		}
		
		System.out.print("The list is : null <-");
		Node currentNode = this.headNode;
		
		while(currentNode.nextNode!=null) {
			System.out.println(currentNode.data.toString() + " <-> ");
		}
		
		System.out.println(currentNode.data.toString() + " -> null");
	}
	
	public void insertAtHead(T data) {
		
		Node newNode = new Node();
		newNode.data = data;
		newNode.nextNode = headNode;
		newNode.prevNode = null;
		if(headNode!=null) {
			headNode.prevNode = newNode;
		}
		
		else {
			tailNode = newNode;
		}
		this.headNode = newNode;
		size++;
	}

	public static void main(String[] args) {

	}

}
