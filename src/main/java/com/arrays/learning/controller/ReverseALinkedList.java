package com.arrays.learning.controller;

public class ReverseALinkedList<T> {
	
	public class Node{
		
		T data;
		Node nextNode;
	}
	
	Node headNode;
	Node following = null;
	Node previous = null;
	int size;
	
	public ReverseALinkedList() {
		this.headNode = null;
		this.size=0;
	}
	
	public void reverseLinkedList(ReverseALinkedList list) {
		
		Node currentNode = list.headNode;
		while(currentNode!=null) {
		following = currentNode.nextNode;
		currentNode.nextNode = previous;
		previous= currentNode;
		currentNode = following;
	}
	list.headNode = previous;
	
	}

}
