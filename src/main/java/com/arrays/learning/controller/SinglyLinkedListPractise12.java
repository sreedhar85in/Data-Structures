package com.arrays.learning.controller;

public class SinglyLinkedListPractise12 <T>{
	
	
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

	
	public SinglyLinkedListPractise12() {
		
		this.headNode = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		
		return this.headNode==null;
	}
	
	public void insertAtHead(T data) {
		
		Node newNode = new Node();
		newNode.data = data;
		newNode.nextNode = headNode;		
		headNode = newNode;
		size++;
		
		
	}
	
	
	public void insertAtEnd(T data) {
		
		if(isEmpty()) {
			insertAtHead(data);
			return;
		}
		
		Node currentNode = this.headNode;
		
		while(currentNode.nextNode!=null) {
			currentNode = currentNode.nextNode;
		}
		
		Node newNode = new Node();
		newNode.data=data;
		newNode.nextNode=null;
		currentNode.nextNode = newNode;
		size++;
		
	} 
	
	public void insertAfterValue(T data, T previousData) {
		
		if(isEmpty()) {
			insertAtHead(data);
			return;
		}
		
		Node currentNode = this.headNode;
		
		while(currentNode!=null) {
			
			//condition check
			
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
		headNode = this.headNode.nextNode;
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
		
		Node currentNode = this.headNode;
		Node prevNode = this.headNode;
		
		while(currentNode!=null) {
			
		//if condn
			
			if(currentNode.data.equals(data)) {
				prevNode.nextNode = currentNode.nextNode;
				size--;
				return;
			}
			
			prevNode = currentNode;
			currentNode = currentNode.nextNode;
			
		}
	}
	
	public void reverse(SinglyLinkedListPractise12<T> list1) {
		
		SinglyLinkedListPractise12<T>.Node next = null;
		SinglyLinkedListPractise12<T>.Node current = list1.getHeadNode();
		SinglyLinkedListPractise12<T>.Node previous = null;
		
		while(current!=null) {
			next = current.nextNode;
			current.nextNode = previous;
			previous=current;
			current = next;
		}
		
		list1.headNode = previous;
	}
	
	public boolean detectLoop(SinglyLinkedListPractise12<T> list) {
		
		SinglyLinkedListPractise12<T>.Node fast =  list.headNode;
		SinglyLinkedListPractise12<T>.Node slow = list.headNode;
		
		while(slow!=null && fast!=null && fast.nextNode!=null) {
			
			fast = fast.nextNode.nextNode;
			slow = slow.nextNode;
			
			if(fast==slow) {
				return true;
			}
					
		}
		return false;
	}
	
	public Object findMiddle(SinglyLinkedListPractise12<T> list) {
		
		SinglyLinkedListPractise12<T>.Node middle = list.getHeadNode();
		SinglyLinkedListPractise12<T>.Node current= list.getHeadNode();
		
		while(middle!=null && current!=null && current.nextNode!=null) {
			current = current.nextNode.nextNode;
			
			if(current!=null) {
				middle = middle.nextNode;
			}
		}
		
		return middle.data;
		
	}
	
	public static <T> SinglyLinkedListPractise12<T> union(SinglyLinkedListPractise12<T> list1, SinglyLinkedListPractise12<T> list2){
		
		if(list1.isEmpty()) {
			return list2;
		}
		
		if(list2.isEmpty()) {
			return list1;
		}
		
		SinglyLinkedListPractise12<T>.Node currentNode = list1.getHeadNode();
		
		while(currentNode.nextNode!=null) {
			currentNode = currentNode.nextNode;
		}
		
		currentNode.nextNode = list2.getHeadNode();
		
		return list1;
		
		
	}
	
	public static <T> boolean contains(T data, SinglyLinkedListPractise12<T> list1) {
		
		SinglyLinkedListPractise12<T>.Node currentNode = list1.getHeadNode();
		
		while(currentNode!=null) {
			
			if(currentNode.data.equals(data)) {
				return true;
			}
				
			currentNode = currentNode.nextNode;
			
		}
		return false;
	}
	
	public static <T> SinglyLinkedListPractise12<T> intersection(SinglyLinkedListPractise12<T> list1, SinglyLinkedListPractise12<T> list2){
		
		
		if(list1.isEmpty()||list2.isEmpty()) {
			return null;
		}
		
		SinglyLinkedListPractise12<T> result = new SinglyLinkedListPractise12<T>();
		
		SinglyLinkedListPractise12<T>.Node currentNode = list1.getHeadNode();
		
		while(currentNode!=null) {
			
			if(contains(currentNode.data, list2)) {
				result.insertAtHead(currentNode.data);
				
			}
			
			currentNode = currentNode.nextNode;
		}
		
		return result;
		
	}

	
	public static <T> Object findTheNthElementfromLast(SinglyLinkedListPractise12<T> list, int n) {
		
		
		if(list.isEmpty()) {
			return null;
		}
		
		SinglyLinkedListPractise12<T>.Node currentNode = list.getHeadNode();
		int listSize = list.getSize();
		
		int formula = listSize - (n-1);
		
		int count = 1;
		
		while(currentNode!=null) {
			//check the condn
			if(count==formula) {
				return currentNode.data;
				
			}
			count++;
			currentNode = currentNode.nextNode;
		}
		
		return null;
		
	}
	
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SinglyLinkedListPractise12<Integer> SL1 = new SinglyLinkedListPractise12<Integer>();
		SL1.insertAtHead(1);
	}

}
