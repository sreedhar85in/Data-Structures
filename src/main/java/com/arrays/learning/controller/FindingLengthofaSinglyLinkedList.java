package com.arrays.learning.controller;

public class FindingLengthofaSinglyLinkedList<T> {

	public class Node{
		T data;
		Node nextNode;
	}
	
	Node headNode;
	
	public int length() {
	      int count = 0;
	      
	      Node currentNode = this.headNode;
	      while(currentNode!=null){
	        currentNode=currentNode.nextNode;
	        count++;
	      }
	      return count;
	    }
	
	public static void main(String[] args) {
		
		FindingLengthofaSinglyLinkedList obj = new FindingLengthofaSinglyLinkedList();
		int length = obj.length();
		System.out.println("lenth of the linked list is : " +length);
	}

}
