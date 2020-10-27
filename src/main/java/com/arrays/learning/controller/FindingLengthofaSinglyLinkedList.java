package com.arrays.learning.controller;

public class FindingLengthofaSinglyLinkedList<T> {

	public class Node{
		T data;
		Node nextNode;
	}
	
	Node headNode;
	int size;
	
	public int length() {
	      int count = 0;
	      
	      Node currentNode = this.headNode;
	      while(currentNode!=null){
	        currentNode=currentNode.nextNode;
	        count++;
	      }
	      return count;
	    }
	
	public boolean isEmpty() {
		
		return headNode==null;
		
	}
	
	public void insertAtHead(T data) {
		
		Node newNode = new Node();
		newNode.data=data;
		newNode.nextNode=headNode;
		headNode=newNode;
		size++;
		
		
	}
	
	public void insertatEnd(T data) {
		
		if(isEmpty()) {
			
			insertAtHead(data);
		}
		
		else {
			Node currentNode = headNode;
			while(currentNode.nextNode!=null) {
				currentNode = currentNode.nextNode;
			}
			Node newNode = new Node();
			newNode.data = data;
			newNode.nextNode=null;
			currentNode.nextNode=newNode;
			size++;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		FindingLengthofaSinglyLinkedList<String> obj = new FindingLengthofaSinglyLinkedList<String>();
		 
		int length = obj.length();
		obj.insertatEnd("This");
		obj.insertatEnd("list");
		obj.insertatEnd("is");
		obj.insertatEnd("Generic");
		int lenthoflist = obj.length();
		System.out.println("lenth of the linked list is : " +lenthoflist);
	}

}
