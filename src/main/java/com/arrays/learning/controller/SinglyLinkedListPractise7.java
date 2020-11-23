package com.arrays.learning.controller;

public class SinglyLinkedListPractise7 <T>{
	
	public class Node{
		
	public	T data;
	public 	Node nextNode;
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
	//constructor
	public  SinglyLinkedListPractise7() {
		
		this.headNode = null;
		this.size=0;
	}
	
	public boolean isEmpty() {
		
		return headNode ==null;
	}
	
	public boolean searchNode(T data) {
		
		Node currentNode = this.headNode;
		
		while(currentNode!=null) {
			if(currentNode.data.equals(data)) {
				return true;
				
			}
			currentNode = currentNode.nextNode;
			
		}
		
		return false;
	}
	
	public static <T> boolean contains(SinglyLinkedListPractise7<T> list1, T data) {
		
		SinglyLinkedListPractise7.Node currentNode = list1.getHeadNode();
		
		while(currentNode!=null) {
			if(currentNode.data.equals(data)) {
				
				return true;
			}
			currentNode = currentNode.nextNode;
		}
		return false;
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
		System.out.println(currentNode.data.toString() + " -> null");
	}
	
	public void insertATHead(T data) {
		
		Node newNode = new Node();
		newNode.data = data;
		newNode.nextNode = headNode;
		headNode = newNode;
		size++;
	}
	
	public void insertAtEnd(T data) {
		
		if(isEmpty()) {
			insertATHead(data);
			return;
		}
		
		Node currenNode = this.headNode;
		while(currenNode.nextNode!=null) {
			currenNode = currenNode.nextNode;
		}
		Node newNode= new Node();
		newNode.data = data;
		currenNode.nextNode = newNode;
		newNode.nextNode = null;
		size++;
		
	}
	
	public void insertAfter(T data, T previousData) {
		Node currentNode = this.headNode;
		while(currentNode!=null) {
			
			if(currentNode.data.equals(previousData)) {
				Node newNode = new Node();
				newNode.data = data;
				newNode.nextNode = currentNode.nextNode;
				currentNode.nextNode = newNode;				
				size++;
				return;
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
		
		Node prevNode = this.headNode;
		Node currenNode = this.headNode;
		while(currenNode.nextNode!=null) {
			prevNode = currenNode;
			currenNode = currenNode.nextNode;
		}
		
		prevNode.nextNode = null;
		size--;
		
		
	}
	
	public void deleteByValue(T data) {
		
		if(isEmpty()) {
			return;
		}
		Node currentNode = this.headNode;
		Node prevNode = null;
		
		if(currentNode.data.equals(data)) {
			deleteAtHead();
			return;
		}
		
		while(currentNode!=null) {
			
			
			
			if(currentNode.data.equals(data)) {
				prevNode.nextNode = currentNode.nextNode;
				size--;
				return;			
			}
			prevNode = currentNode;
			currentNode =currentNode.nextNode;
		}
		
	}
	
	
	public Object findMiddle(SinglyLinkedListPractise7<T> list) {
		
		SinglyLinkedListPractise7.Node currentNode = list.headNode;
		SinglyLinkedListPractise7.Node middleNode = list.headNode;
		
		while(currentNode!=null && currentNode.nextNode!=null) {
			currentNode = currentNode.nextNode.nextNode;
		
		
		if(currentNode!=null) {
			middleNode = middleNode.nextNode;
			
		}
		}
		return middleNode.data;
	}
	
	public void removeDuplicate(SinglyLinkedListPractise7<T> list) {
		
		SinglyLinkedListPractise7.Node currentNode = list.headNode; //outer loop
		SinglyLinkedListPractise7.Node compareNode = null; //inner loop
		
		while(currentNode!=null && currentNode.nextNode!=null) {
			
			compareNode = currentNode;
			
			
			while(compareNode.nextNode!=null) {
				
				if(currentNode.data.equals(compareNode.nextNode.data)) {
					
					compareNode.nextNode=compareNode.nextNode.nextNode;
					
					
				}
				
				//
				else {
				compareNode = compareNode.nextNode;
				}
			}
			
			//
			currentNode = currentNode.nextNode;
		}
		
		
	}
	
	public static <T> void reverseLinkedList(SinglyLinkedListPractise7<T> list) {
		
		SinglyLinkedListPractise7.Node previous = null;
		SinglyLinkedListPractise7.Node current = list.headNode;
		SinglyLinkedListPractise7.Node next = null;
		
		while(current!=null) {
			
			next =current.nextNode;
			current.nextNode = previous;
			previous = current;
			current=next;
			
		}
		list.headNode = previous;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SinglyLinkedListPractise7<Integer> obj = new SinglyLinkedListPractise7<Integer>();
		obj.insertAtEnd(1);
		obj.insertAtEnd(2);
		obj.insertAtEnd(3);
		obj.insertAtEnd(4);
		obj.printList();
		obj.reverseLinkedList(obj);
		obj.printList();

	}

}
