package com.arrays.learning.controller;

public class SinglyLinkedListPractise10 <T>{
	
	public class Node{
		
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
	
	
	public SinglyLinkedListPractise10() {
		this.headNode = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		
		return this.headNode==null;
	}
	
	public void printList() {
		if(isEmpty()) {
			System.out.println("List is Empty");
		}
		
		System.out.print("List is : ");
		Node currentNode = this.headNode;
		
		while(currentNode.nextNode!=null) {
			
			System.out.println(currentNode.data.toString()+" -> ");
		}

		System.out.println(currentNode.data.toString()+"-> null");
		
	}
	
	public void insertAtHead(T data) {
		
		Node newNode = new Node();
		
		newNode.data = data;
		newNode.nextNode=null;
		headNode=newNode;
		size++;
	}
	
	public void insertATEnd(T data) {
		if(isEmpty()) {
			insertAtHead(data);
			return;
		}
		Node currentNode = this.headNode;
		
		while(currentNode.nextNode!=null) {
			
		}
		
		Node newNode = new Node();
		newNode.data= data;
		newNode.nextNode=null;
		currentNode.nextNode=newNode;
		size++;
	}
	
	public void insertAfterValue(T data, T previousData) {
		
		Node curreNode = this.headNode;
		
		while(curreNode!=null) {
			
			if(curreNode.data.equals(previousData)) {
				
				Node newNode = new Node();
				newNode.data=data;
				newNode.nextNode= curreNode.nextNode;
				curreNode.nextNode=newNode;
				size++;
				return;
				
			}
			
		}
		
		
	}
	
	public void deleteAtHead() {
		
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
			currentNode=currentNode.nextNode;
			
		}
		
		prevNode.nextNode=null;
		size--;
	}
	
	public void deleteByValue(T data) {
		
		Node currentNode = this.headNode;
		Node prevNode = this.headNode;
		
		if(currentNode.data.equals(data)) {
			deleteAtHead();
			return;
		}
		
		while(currentNode!=null) {
			
			if(currentNode.data.equals(data)) {
				prevNode.nextNode = currentNode.nextNode;
				size--;
			}
			
			prevNode=currentNode;
			currentNode=currentNode.nextNode;
			
		}
		
	}
	
	public void reverse(SinglyLinkedListPractise10<T> list) {
		SinglyLinkedListPractise10<T>.Node next = null;
		SinglyLinkedListPractise10<T>.Node current = list.headNode;		
		SinglyLinkedListPractise10<T>.Node prev = null;
		
		while(current!=null) {
			next = current.nextNode;
			current.nextNode=prev;
			prev = current;
			current = next;
		}
		
		list.headNode= prev;
	}
	
	public boolean detectLoop(SinglyLinkedListPractise10<T> list) {
		
		SinglyLinkedListPractise10<T>.Node slow = list.headNode;
		SinglyLinkedListPractise10<T>.Node fast = list.headNode;
		
		while(slow!=null && fast!=null && fast.nextNode!=null) {
			
			fast = fast.nextNode.nextNode;
			slow = slow.nextNode;
			
			if(slow==fast) {
				return true;
			}
			
		}
		return false;
	}
	
	public Object findMiddle(SinglyLinkedListPractise10<T> list) {
		
		SinglyLinkedListPractise10<T>.Node currentNode = list.headNode;
		SinglyLinkedListPractise10<T>.Node middleNode = list.headNode;
		
		while(middleNode!=null && currentNode!=null && currentNode.nextNode!=null) {
			
			currentNode =  currentNode.nextNode.nextNode;
					
					if(currentNode!=null) {
						middleNode = middleNode.nextNode;
					}
		}
		
		return middleNode.data;
		
	}
	
	public void removeDuplicates(SinglyLinkedListPractise10<T> list) {
		
		SinglyLinkedListPractise10<T>.Node currentNode =  list.getHeadNode(); // outer loop
		SinglyLinkedListPractise10<T>.Node compareNode = null; //inner loop
		
		while(currentNode!=null && currentNode.nextNode!=null) {
			compareNode = currentNode;
			
			while(compareNode.nextNode!=null) {
				if(currentNode.data.equals(compareNode.nextNode)) {
					
					compareNode.nextNode = compareNode.nextNode.nextNode;
				}
				
				else {
					compareNode = compareNode.nextNode;
				}
				
				
			}
			currentNode = currentNode.nextNode;
		}
	}
	
	
}
