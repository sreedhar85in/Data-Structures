package com.arrays.learning.controller;

import java.util.LinkedList;

public class LinkedListInsertatHead<T> {

	public class Node{
		
		public T data;
		public Node nextNode;
		
	}
	
	public Node headNode;
	public int size;
	//LinkedList test = new LinkedList();
	//constructor
	
	public LinkedListInsertatHead() {
		headNode=null;
		size=0;
		
	}
	
	public  boolean isEmpty() {
		
		if (headNode == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void insertAtHead(T data) {
		//creating a new node and assigning it the new data value
		
		Node newNode= new Node();
		newNode.data= data;
		newNode.nextNode = headNode;
		headNode = newNode;
		size++;
	}
	
	//Helper fundtion to printList
	
	public void printList() {
		
		if(isEmpty()) {
			System.out.println("List is Empty");
			return;
		}
		
		Node temp = headNode;
		System.out.print("List : ");
		while(temp.nextNode!=null) {
			System.out.print(temp.data.toString() + " -> ");
			temp=temp.nextNode;
		}
		System.out.println(temp.data.toString() + " -> null");
	}
	
	
	 public void insertAtEnd(T data) {
	       if(isEmpty()){
	           insertAtHead(data);
	          
	       }
	       else{
	           Node temporary = headNode;
	           while(temporary.nextNode!=null){
	              // System.out.println("Not the tail of the ode train yet!!");
	               temporary= temporary.nextNode;
	           }
	           
	          Node newNode2 = new Node();
	          newNode2.data = data;
	          newNode2.nextNode = null;
	          temporary.nextNode=newNode2;
	          size++;
	       }

	    }
	 
	 public void insertafter(T data, T previousData) {
		 
		 Node newNode = new Node();
		 newNode.data = data;
		 
		 
		 //assign head node to a temp node for preparing to traversal of the linkedlist.
		 Node currentNode = headNode;
		 
		 //traverse the linkedlist
		 while(currentNode!=null && !currentNode.data.equals(previousData)) {
			 currentNode = currentNode.nextNode;
			 
		 }
		 
		 //if such a node is found, then point our newnode to currentnodes next element.
		 
		 newNode.nextNode = currentNode.nextNode;
		 currentNode.nextNode=newNode;
		 size++;
		 
		 
		 
		 
	 }
	 
	 public boolean searchNode(T data) {
	        Node tempNode = this.headNode;
	        
	        if(isEmpty()) {
	        	return false;
	        }
	        
	        while(tempNode.nextNode!=null && !tempNode.data.equals(data)) {
	        	
	        	tempNode = tempNode.nextNode;
	        }
	       
	        if(tempNode.data.equals(data)) {
	        	return true;
	        }
	        
	        else {
	        	return false;
	        }
	        
	    }
	
	 
	 public boolean optimisedSearchNode(T data) {
		 
		 //start from the first element
		 Node currentNode = this.headNode;
		 
		 //traverse the whole list
		 
		 while(currentNode!=null) {
			 
			 if(currentNode.data.equals(data)) {
				 return true; //value found
			 }
			 
			 currentNode = currentNode.nextNode;
		 }
		 
		 return false; // value not found
		 
		 
	 }
	 
	 public void deleteAtHead() {
		 //If list is empty then simply return
		 if (isEmpty()) {
			 return;
		 }
		 //make the next node of the headnode equal to new headNode
		 headNode = headNode.nextNode;
		 size--;
	 }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListInsertatHead obj = new LinkedListInsertatHead();
		boolean test =obj.isEmpty();
		System.out.println("the value of the boolean is :" + test);
		obj.printList();
		for(int i=1;i<=10; i++) {
			
			obj.insertAtHead(i);
			//obj.insertAtEnd(i);
			obj.printList();
		}
		
		obj.insertafter(2,8);
		obj.printList();
		
	}

}
