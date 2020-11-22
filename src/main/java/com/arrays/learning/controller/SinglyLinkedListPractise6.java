package com.arrays.learning.controller;



public class SinglyLinkedListPractise6<T> {
	
	
	public class Node{
		
		T data;
		Node nextNode;
	}
	
	Node headNode;
	int size;
	
	public void SinglyLinkedListPractise6() {
		this.headNode = null;
		this.size=0;
	}

	
	public boolean isEmpty() {
		return headNode ==null;
	}
	
	public void printList() {
		
		if(isEmpty()) {
			System.out.println("List is Empty");
			return;
			
		}
		
		System.out.print("List is : ");
		
		Node currentNode = headNode;
		
		while(currentNode.nextNode!=null) {
			System.out.print( currentNode.data.toString()+" -> ");
			currentNode = currentNode.nextNode;
			
		}
		
		System.out.println(currentNode.data.toString() + "-> null");
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
		
		Node currentNode = headNode;
		
		while(currentNode.nextNode!=null) {
			
			currentNode = currentNode.nextNode;
			
		}
		
		Node newNode = new Node();
		newNode.data=data;
		currentNode.nextNode = newNode;
		newNode.nextNode = null;
		size++;
		
	}
	
	
	public void insertAfter(T data, T previousData) {
		
		
		Node currentNode = headNode;
		
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
		
		headNode = headNode.nextNode;
		size--;
	}
	
	public void deletebyValue(T data) {
		
		if(isEmpty()) {
			return;
		}
		
		Node currentNode = headNode;
		Node prevNode = headNode;
		
		while(currentNode!=null) {
			
			if(currentNode.data.equals(data)) {
				prevNode.nextNode = currentNode.nextNode;
				//this can  also write, 
				
				
				
				return;
			}
			
			//traversal until value is found.
			prevNode = currentNode;
			currentNode = currentNode.nextNode;
		}
	}
	
	public Object findMiddleNode(SinglyLinkedListPractise6 list) {
		
		SinglyLinkedListPractise6.Node currentNode = list.headNode;
		SinglyLinkedListPractise6.Node middleNode = list.headNode;
		
		while(middleNode!=null&& currentNode!=null && currentNode.nextNode!=null) {
			
			//jump the currentNode pointer to two places
			
			currentNode = currentNode.nextNode.nextNode;
			
			if(currentNode!=null) {
				middleNode = middleNode.nextNode;
			}
			
			
			
			
		}
		
		return middleNode.data;
		
		
		
	}
	
	
	
	public void removeDuplicates(SinglyLinkedListPractise6 list) {
		
		SinglyLinkedListPractise6.Node currentNode = list.headNode; //outer loop
		SinglyLinkedListPractise6.Node compareNode = list.headNode; //inner loop
		
		while(currentNode!=null&& currentNode.nextNode!=null) {
	
			compareNode = currentNode;
			
			while(compareNode.nextNode!=null) {
				
				
				if(currentNode.data.equals(compareNode.nextNode.data)) {
					compareNode.nextNode = compareNode.nextNode.nextNode;
					
				}
				
				else{
					
					compareNode = compareNode.nextNode;
				}
				
			}
			
			currentNode = currentNode.nextNode;
			
		}
		
	}
	
	public static <T> SinglyLinkedListPractise6<T> union(SinglyLinkedListPractise6<T> list1, SinglyLinkedListPractise6<T> list2) {
		
		SinglyLinkedListPractise6<T> resultList = list1;
		
		SinglyLinkedListPractise6.Node tempNode = list2.headNode;
		
		while(tempNode!=null) {
			resultList.insertAtEnd((T) tempNode.data);
			tempNode = tempNode.nextNode;
		}
		resultList.removeDuplicates(resultList);
		return resultList;
		
		
		
	}
	
	public static <T> SinglyLinkedListPractise6<T> intersection(SinglyLinkedListPractise6<T> list3, SinglyLinkedListPractise6<T> list4){
		
		SinglyLinkedListPractise6<T> resultList2 = new SinglyLinkedListPractise6<T>();
		
		//intersection is the direct opposite to removing duplicates and adding them to a list.
		
		//resultList = list1;
		
		//SinglyLinkedListPractise2<T>.Node currentNode = list2.headNode;
		
		//list1 is outer loop
		
		//list2 is inner loop.
		
		SinglyLinkedListPractise6<T>.Node currentNode = list3.headNode; //outer loop
		SinglyLinkedListPractise6<T>.Node compareNode = null; //inner loop
		
		while(currentNode!=null&& currentNode.nextNode!=null) {
			
			compareNode = list4.headNode;
			
			while(compareNode.nextNode!=null) {
				
				
				//check if intersects
				
				if(currentNode.data.equals(compareNode.data)) {
					
					
					resultList2.insertAtEnd(currentNode.data);
					
				}
				
				
				//traverse the inner loop
				compareNode = compareNode.nextNode;
			}
			
			//traverse outer loop
			currentNode = currentNode.nextNode;
		}
		
		
				
			return resultList2;
		
	}
	
	
	
	public static void main(String[] args) {
		SinglyLinkedListPractise6<Integer> obj1 =new SinglyLinkedListPractise6<Integer>();
		SinglyLinkedListPractise6<Integer> obj2 =new SinglyLinkedListPractise6<Integer>();
		obj1.insertAtEnd(1);
		obj1.insertAtEnd(2);
		obj1.insertAtEnd(3);
		obj1.insertAtEnd(4);
		obj1.insertAtEnd(5);
		obj1.printList();
		
		obj2.insertAtEnd(4);
		obj2.insertAtEnd(6);
		obj2.insertAtEnd(7);
		obj2.insertAtEnd(2);
		obj2.insertAtEnd(8);
		obj2.printList();
		
		SinglyLinkedListPractise6 test = union(obj1, obj2);
		test.printList();
		SinglyLinkedListPractise6<Integer> obj3 =new SinglyLinkedListPractise6<Integer>();
		obj3.insertAtEnd(1);
		obj3.insertAtEnd(2);
		obj3.insertAtEnd(3);
		obj3.insertAtEnd(4);
		obj3.insertAtEnd(5);
		obj3.printList();
		SinglyLinkedListPractise6 test1 = intersection(obj3, obj2);
		test1.printList();
	}

}
