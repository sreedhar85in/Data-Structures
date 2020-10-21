package com.arrays.learning.controller;

public class DoublyLinkedList<T> {
	
	
	public class Node{
		
		public T data;
		public Node nextNode;
		public Node prevNode;
		
		
	}
	
	public Node headNode;
	public int size;

	public DoublyLinkedList() {
		this.headNode = null;
	}
	
	
	public boolean isEmpty() {
		if (headNode == null) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isEmptyNew() {
		
		return headNode==null;
	}
	
	public void deletebyValue(T data) {
		
		if(isEmpty()) {
			return;
		}
		
		//start from head node
		
		Node currentNode = this.headNode;
		
		if(currentNode.data.equals(data)) {
			//found the elemenet at head. so used delete at head method.
			return;
		}
		
		//traverse the list searching for the data to delete
		while(currentNode!=null) {
			
			if(data.equals(currentNode.data)) {
				
				currentNode.prevNode.nextNode = currentNode.nextNode;
			
			
			if(currentNode.nextNode!=null){
				currentNode.nextNode.prevNode = currentNode.prevNode;				
			}
			
			size--;
			return;
			}
			currentNode = currentNode.nextNode;
		}
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
