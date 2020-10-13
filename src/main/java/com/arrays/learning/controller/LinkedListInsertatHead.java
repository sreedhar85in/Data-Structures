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
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListInsertatHead obj = new LinkedListInsertatHead();
		boolean test =obj.isEmpty();
		System.out.println("the value of the boolean is :" + test);
		obj.printList();
		for(int i=1;i<=10; i++) {
			
			//obj.insertAtHead(i);
			obj.insertAtEnd(i);
			obj.printList();
		}
		
	}

}
