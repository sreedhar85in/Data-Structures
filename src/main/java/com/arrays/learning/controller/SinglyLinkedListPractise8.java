package com.arrays.learning.controller;



public class SinglyLinkedListPractise8 <T>{
	
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
	public class Node{
		
		T data;
		Node nextNode;
	}
	
	private Node headNode;
	private int size;
	
	public SinglyLinkedListPractise8() {
		
		this.headNode = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		
		return headNode ==null;
	}
	
	public void printList() {
		
	if(isEmpty()) {
	System.out.println("List is Empty !");
	}
	
	System.out.print("List is : ");
	
	Node currentNode = this.headNode;
	
	while(currentNode.nextNode!=null) {
		
		System.out.println(currentNode.data.toString() + " -> ");
		
		currentNode = currentNode.nextNode;
	}
	
	System.out.println(currentNode.data.toString() + " -> null");
	
	
	} 
	
	public void insertATHead(T data) {
		
		Node newNode = new Node();
		newNode.data=data;
		newNode.nextNode=null;
		headNode=newNode;
		size++;
	}
	
	public void insertATEnd(T data) {
		if(isEmpty()) {
			insertATHead(data);
			return;
		}
		
		Node currentNode= headNode;
		while(currentNode.nextNode!=null) {
			currentNode = currentNode.nextNode;
		}
		
		Node newNode = new Node();
		newNode.data=data;
		currentNode.nextNode=newNode;
		newNode.nextNode=null;
		size++;
		
	}
	
	public void insertAfteraValue(T data, T previousData) {
		
		Node currentNode = headNode;
		
		while(currentNode!=null) {
			
			//
			if(currentNode.data.equals(previousData)) {
				Node newNode = new Node();
				newNode.data=data;
				newNode.nextNode = currentNode.nextNode;
				currentNode.nextNode=newNode;
				size++;
				return;
				
			}
			
			currentNode = currentNode.nextNode;
		}
	}
	
	public void deleteAtHead() {
		
		headNode = headNode.nextNode;
		size--;
	}
	
	public void deleteAtEnd() {
		Node curreNode  = this.headNode;
		Node prevNode = this.headNode;
		
		
		while(curreNode.nextNode!=null) {
			
			//
			prevNode = curreNode;
			curreNode = curreNode.nextNode;
		}
		
		prevNode.nextNode=null;
		size--;
		
	}
	
	public void deleteByValue(T data) {
		
		Node curreNode = this.headNode;
		Node prevNode = this.headNode;
		if(curreNode.data.equals(data)) {
			deleteAtHead();
			return;
		}
		while(curreNode!=null) {
			
			
			
			if(curreNode.data.equals(data)) {				
				prevNode.nextNode = curreNode.nextNode;
				size--;
				return;
			}
			
			prevNode = curreNode;
			curreNode = curreNode.nextNode;
		}
		
	}
	
	
	public Object findmiddle(SinglyLinkedListPractise8 list) {
		
		Node currentNode = this.headNode;
		Node middleNode = this.headNode;
		
		while(middleNode!=null && currentNode!=null & currentNode.nextNode!=null) {
			
			currentNode = currentNode.nextNode.nextNode;
			
			if(currentNode!=null) {
				middleNode = middleNode.nextNode;
			}
		}
		return middleNode.data.toString();
	}
	
	public void reverse(SinglyLinkedListPractise8<T> list) {
		
		SinglyLinkedListPractise8<T>.Node nextNode = null;
		SinglyLinkedListPractise8<T>.Node currentNode = list.headNode;
		SinglyLinkedListPractise8<T>.Node prevNode = null;
		
		while(currentNode!=null) {
			nextNode = currentNode.nextNode;
			currentNode.nextNode = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}
		list.headNode= prevNode;
		//changes for practise.
		
	}
	
	public boolean detectloop(SinglyLinkedListPractise8<T> list) {
		
		SinglyLinkedListPractise8.Node slow = list.headNode;
		SinglyLinkedListPractise8.Node fast = list.headNode;
		
		while(slow!=null&& fast!=null&& fast.nextNode!=null) {
			
			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;
			
			if(slow ==fast) {
				return true;
			}
			
		}
		return false;
	}
	
	
	
	public void removeduplicates(SinglyLinkedListPractise8<T> list) {
		
		SinglyLinkedListPractise8.Node currentNode = list.headNode;//outer loop
		
		SinglyLinkedListPractise8.Node compareNode = null; //inner loop
		
		while(currentNode!=null && currentNode.nextNode!=null) {
			
			compareNode= currentNode;
			
			while(compareNode.nextNode!=null) {
				
				//check if duplicates
				if(currentNode.data.equals(compareNode.nextNode.data)) {
					compareNode.nextNode = compareNode.nextNode.nextNode;
					
				}
				
				else {
					
					compareNode = compareNode.nextNode;
				}
				
			}
			
			currentNode = currentNode.nextNode;
		}
		
		
	}
	
	public static <T> boolean contains(SinglyLinkedListPractise8 list, T data) {
		
		SinglyLinkedListPractise8.Node currentNode = list.getHeadNode();
		
		while(currentNode!=null) {
			
			if(currentNode.data.equals(data)) {
				return true;
			}
			
			currentNode = currentNode.nextNode;
			
		}
		return false;
		
		
	}
	
	
	

	
	public static <T> SinglyLinkedListPractise8<T>  union(SinglyLinkedListPractise8 list1, SinglyLinkedListPractise8 list2) {
		
		//if one list is empty return other
		
		if(list1.isEmpty()) {
			return list2;
		}
		
		if(list2.isEmpty()) {
			return list1;
		}
		
		//take  the head of the first list
		
		SinglyLinkedListPractise8.Node last = list1.getHeadNode();
		
		//traverse it to the last node;
		
		while (last.nextNode!=null) {
			
			last = last.nextNode;
		}
		
		//attach the last element of list1 to the head of list2.
		
		last.nextNode = list2.getHeadNode();
		
		//remove duplicates
		
		list1.removeduplicates(list1);
		
		return list1;
	}
	
	public static <T> SinglyLinkedListPractise8<T> intersection(SinglyLinkedListPractise8<T> list1, SinglyLinkedListPractise8<T> list2) {
		
		SinglyLinkedListPractise8<T> result = new SinglyLinkedListPractise8<T>();
		
		if(list1.isEmpty()|| list2.isEmpty()) {
			
			return result;
		}
		
		
		SinglyLinkedListPractise8<T>.Node currentNode = list1.getHeadNode();
		
		while(currentNode!=null) {
			
			if(contains(list2, currentNode.data)) {
				result.insertATHead(currentNode.data);
				
				
			}
			
			currentNode = currentNode.nextNode;
		}
		
		return result;
	}
}
