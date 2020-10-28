package com.arrays.learning.controller;

public class FindingtheMiddleNode<T> {
	
	public class Node{
		
		T data;
		Node nextNode;
	}
	
	Node headNode;
	int size;
	
	public FindingtheMiddleNode() {
		this.headNode = null;
		this.size = 0;
	}
	
	public void insertAtHead(T data) {
		
		Node newNode = new Node();
		newNode.data = data;
		newNode.nextNode = headNode;
		headNode= newNode;
		size++;
	}
	
	public void insertAtEnd(T data) {
		
		Node lastNode = this.headNode;
		while(lastNode.nextNode!=null) {
			lastNode = lastNode.nextNode;
			
		}
		
		Node newNode = new Node();
		newNode.data =data;
		newNode.nextNode=null;
		lastNode.nextNode=newNode;
		size++;
	}
	
	public boolean isEmpty() {
		
		return headNode==null;
	}
	
	public void insertAfter(T data, T previousData) {
		
		Node newNode= new Node();
		newNode.data = data;
		
		//assign the currentnode to headnode for the preparation of traversal.
		Node currentNode = headNode;
		while(currentNode!=null && !currentNode.data.equals(previousData)) {
			
			currentNode = currentNode.nextNode;
		}
		
		//if such a node is found then point our new node after the previousdata node.
		
		if(currentNode.data.equals(previousData)) {
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
		
		Node currentNode = this.headNode;
		Node prevNode = null;
		
		if (currentNode.data.equals(data)){
			//data is at head , hence use delete at head method.
			deleteAtHead();
			return;
		}
		
		//traverse the list searching for the data to delete.
		
		while(currentNode!=null) {
			
			//Node to delete is found
			
			if(currentNode.data.equals(data)) {
				
				prevNode.nextNode= currentNode.nextNode;
				size--;
				return;
				
				
			}
			prevNode = currentNode;
			currentNode = currentNode.nextNode;
		}
		
		
		
	}
	
	public boolean searchNode(T data) {
		
		//start from the firstnode
		Node currentNode = this.headNode;
		while(currentNode!=null) {
			
			//if the data is found
			if(currentNode.data.equals(data)) {
				return true;
			}
			
			
		//if data is not found then iterate through the linkedlist
			currentNode = currentNode.nextNode;
		}
		//even after iterating the whole linkedlistt the data is not found, hence returning as false.
		return false;
	}
	
	public void printList() {
		
		if(isEmpty()) {
			System.out.println("The List is Empty");
			return;
			
		}
		
		Node temp = headNode;
		System.out.print("List : ");
		while(temp.nextNode!=null) {
			System.out.print(temp.data.toString() + " -> ");
			temp = temp.nextNode;
		}
		System.out.print(temp.data.toString() + " -> null");
		
	}
	public Object findMiddle(FindingtheMiddleNode<T> list) {
		if(list.isEmpty()) {
			return null;
		}
		
		FindingtheMiddleNode.Node mid = list.headNode;
		FindingtheMiddleNode.Node current = list.headNode;
		while(mid!=null && current!=null & current.nextNode.nextNode!=null) {
			
		current = current.nextNode.nextNode;
		
		if(current!=null) {
			mid = mid.nextNode;
		}
			
		}
		
		return mid.data;
		
		
		
		
	} 

}
