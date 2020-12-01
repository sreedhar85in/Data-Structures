package com.arrays.learning.controller;

public class DoublyLinkedListChallengePalindrome<T> {

	public class Node {

		T data;
		Node nextNode;
		Node previousNode;
	}

	private Node headNode;
	private Node tailNode;
	private int size;

	public DoublyLinkedListChallengePalindrome() {
		this.headNode = null;
		this.tailNode = null;
		this.size = 0;
	}

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

	public boolean isEmpty() {

		return this.headNode == null && this.tailNode == null;
	}

	public void insertAtHead(T data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.nextNode = this.headNode;
		newNode.previousNode = null;
		if (headNode != null) {
			headNode.previousNode = newNode;
		}

		else {
			tailNode = newNode;
		}

		this.headNode = newNode;
		size++;

	}

	public void insertAtEnd(T data) {

		if (isEmpty()) {
			insertAtHead(data);
			return;
		}

		Node newNode = new Node();
		newNode.data = data;
		newNode.nextNode = null;
		newNode.previousNode = tailNode;
		tailNode.nextNode = newNode;
		tailNode = newNode;
		size++;

	}

	public void printList() {

		if (isEmpty()) {
			System.out.println("List is Empty!");
			return;
		}

		Node currentNode = headNode;

		System.out.print("List is : null <-");

		while (currentNode.nextNode != null) {
			System.out.print(currentNode.data.toString() + " <->");
			currentNode = currentNode.nextNode;

		}

		System.out.println(currentNode.data.toString() + " -> null");

	}

	public void deleteAtHead() {

		if (isEmpty()) {
			return;
		}

		headNode = headNode.nextNode;

		if (headNode == null) {
			tailNode = null;
		}

		else {
			headNode.previousNode = null;
		}
		size--;
	}

	public void deleteAtTail() {

		if (isEmpty()) {
			return;
		}

		tailNode = tailNode.previousNode;
		if (tailNode == null) {
			headNode = null;
		} else {
			tailNode.nextNode = null;
		}
		size--;
	}
	
	public void deleteByValue(T data) {
		
		if (isEmpty()) {
			return;
		}
		
		Node currentNode = this.headNode;
		
		if(currentNode.data.equals(data)) {
			deleteAtHead();
			return;
		}
		
		while(currentNode!=null) {
			
			//node to delete is found
			
			if(currentNode.data.equals(data)) {
				currentNode.previousNode.nextNode = currentNode.nextNode;
				
				if(currentNode.nextNode!=null) {
					currentNode.nextNode.previousNode = currentNode.previousNode;
							
				}
				size--;
			}
			currentNode = currentNode.nextNode;
			
		}
		
		
		
	}
	
	public static <T> boolean isPalindrome(DoublyLinkedListChallengePalindrome<T> list) {
		
		DoublyLinkedListChallengePalindrome<T>.Node start = list.getHeadNode();
		DoublyLinkedListChallengePalindrome<T>.Node end = list.getTailNode();
		
		//if list is empty its a palindrome, return true.
		
		if(start ==null) {
			return true;
		}
		
		while(start!=null) {
			//if data mismatches at any point of time return false
			
			if(start.data!=end.data) {
				return false;
			}
			start = start.nextNode;
			end = end.nextNode;
		}
		return true; // if data didnt mismatch at any point, list is a palindrome.
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DoublyLinkedListChallengePalindrome<Integer> obj = new DoublyLinkedListChallengePalindrome<Integer>();
		obj.insertAtEnd(1);
		obj.insertAtEnd(2);
		obj.insertAtEnd(3);
		obj.insertAtEnd(4);
		obj.printList();
	}

}
