package com.arrays.learning.controller;

public class CheckLoopSinglyLinkedList<T> {
	
	public class Node{
		
		T data;
		Node nextNode;
	
	}
	
	public Node headNode;
	public int size;
	
	public CheckLoopSinglyLinkedList() {
		
		this.headNode = null;
		this.size = 0;
	}
	
//	public boolean nodeVisited = true;
	
	public boolean checkLoop(CheckLoopSinglyLinkedList<T> list) {
		
		CheckLoopSinglyLinkedList<T>.Node slow = list.headNode;
		CheckLoopSinglyLinkedList<T>.Node fast = list.headNode;
		
		while(slow!=null && fast!=null && fast.nextNode!=null) {
			
			slow=slow.nextNode;
			fast = fast.nextNode.nextNode;
			//the fast pointer will jump two steps, when the pointer becomes equal then there must be a loop.
			
			if(slow==fast) {
				return true;
			}
			
		}
		return false;
		
	}

}
