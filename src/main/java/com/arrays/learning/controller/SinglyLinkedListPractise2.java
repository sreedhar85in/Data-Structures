package com.arrays.learning.controller;

public class SinglyLinkedListPractise2<T> {

	public class Node {

		T data;
		Node nextNode;
	}

	Node headNode;
	int size;

	public SinglyLinkedListPractise2() {
		this.headNode = null;
		this.size = 0;
	}

	public boolean isEmpty() {
		return headNode == null;
	}

	public void printList() {
		if (isEmpty()) {
			System.out.println("List is Empty");
		}

		System.out.print("List is : ");
		Node currentNode = headNode;
		while (currentNode.nextNode != null) {
			System.out.print(currentNode.data.toString() + " -> ");
			currentNode = currentNode.nextNode;
		}
		System.out.println(currentNode.data.toString() + " -> null ");
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
		
		//now we should have reached the last node
		Node newNode = new Node();
		newNode.data = data;
		currentNode.nextNode=newNode;
		newNode.nextNode=null;
		size++;
	}
	
	public void insertAfter(T data, T previousdata) {
		
		
		
		Node currentNode = headNode;
		Node newNode = new Node();
		newNode.data=data;
		while(currentNode!=null){
			
			//first check if the currentnode is having previous data, if not start iterating.
			
			if(currentNode.data.equals(previousdata)) {
			newNode.nextNode=currentNode.nextNode;
			currentNode.nextNode=newNode;
			size++;
			return;
			}
			
			currentNode=currentNode.nextNode;
		}
		
		
		
	}
	
	public boolean search(T data) {
		if(isEmpty()) {
			return false;
		}
		Node currentNode = headNode;
		while(currentNode!=null) {
			//if its found, return true
			if(currentNode.data.equals(data)) {
				return true;
			}
			//if not found, then iterate until null
			currentNode = currentNode.nextNode;
			
		} 
		//if even after iterating the whole list the node is not found return false now.
		return false;
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
		Node prevNode = null;
		
		while(currentNode!=null ) {
			
			//if such a node is found
			if(currentNode.data.equals(data)) {
				prevNode.nextNode=currentNode.nextNode;
				size--;
				return;
				
			}
			prevNode = currentNode;
			currentNode=currentNode.nextNode;
		}
		
		
		
	}
	
	public Object findMiddleNode(SinglyLinkedListPractise2 list) {
		Node currentNode = list.headNode;
		Node middleNode = list.headNode;
		
		while(middleNode!=null&&currentNode!=null&&currentNode.nextNode!=null) {
			
			//jump the current node pointer to two places
			currentNode = currentNode.nextNode.nextNode;
			
			//check if the current is not null , if not, then move middel node pointer by one.
			if(currentNode!=null) {
				middleNode=middleNode.nextNode;
			}
			
		}
	
		return middleNode.data;
	}
	
	public void removeDuplicates(SinglyLinkedListPractise2 list) {
		
		SinglyLinkedListPractise2.Node currentNode = list.headNode; // outer loop
		SinglyLinkedListPractise2.Node compareNode = null; //inner loop
		
		while(currentNode!=null && currentNode.nextNode!=null) {
			compareNode = currentNode;
			
			while(compareNode.nextNode!=null) {
				//check if there is any duplicates and remove it below
				if(currentNode.data.equals(compareNode.nextNode.data)) {
					compareNode.nextNode = compareNode.nextNode.nextNode;
					
				}
				//dont think there is a need for an else condiion here since it will not remove multiple duplicates in a list.
				else {
				compareNode = compareNode.nextNode;
				}
			}
			
			currentNode = currentNode.nextNode;
		}
	}
	
	public static <T> SinglyLinkedListPractise2<T> union(SinglyLinkedListPractise2<T> list1, SinglyLinkedListPractise2<T> list2){
		
		SinglyLinkedListPractise2<T> result = new SinglyLinkedListPractise2<T>();
		//code or solution here
		//result.headNode=list1.headNode;
		SinglyLinkedListPractise2.Node tempNode = list1.headNode;
		while(tempNode!=null) {
			
			result.insertAtEnd((T) tempNode.data);
			tempNode = tempNode.nextNode;
			
		}
		
		tempNode = list2.headNode;
		
		while(tempNode!=null) {
			result.insertAtEnd((T) tempNode.data);
			tempNode = tempNode.nextNode;
		}
		
		
		return result;
	}
	
	public static void main(String[] args) {
		SinglyLinkedListPractise2<String> obj = new SinglyLinkedListPractise2<String>();
		SinglyLinkedListPractise2<String> obj3 = new SinglyLinkedListPractise2<String>();
		SinglyLinkedListPractise2<Integer> obj2 = new SinglyLinkedListPractise2<Integer>();
		obj.insertAtEnd("This");
		obj.insertAtEnd("is");
		obj.insertAtEnd("a");
		obj.insertAtEnd("test");
		obj.printList();
		
		obj3.insertAtEnd("Game");
		obj3.insertAtEnd("is");
		obj3.insertAtEnd("just");
		obj3.insertAtEnd("beginning");
		obj3.printList();
		
		SinglyLinkedListPractise2 test = union(obj, obj3);
		test.printList();
		
		
		
		
		/*
		 * obj.insertAfter("final", "This"); obj.printList(); boolean search; search =
		 * obj.search("final"); System.out.println("value of search is : " + search);
		 * obj.deletebyValue("final"); obj.printList(); search = obj.search("final");
		 * System.out.println("value of search is : " + search);
		 * 
		 * //obj2 obj2.insertAtEnd(1); obj2.insertAtEnd(2); obj2.insertAtEnd(3);
		 * obj2.insertAtEnd(4); obj2.insertAtEnd(5); obj2.insertAtEnd(6);
		 * obj2.insertAtEnd(7); obj2.insertAtEnd(8); obj2.insertAtEnd(8);
		 * obj2.insertAtEnd(8); obj2.insertAtEnd(5); obj2.printList(); int test = (int)
		 * obj2.findMiddleNode(obj2); System.out.println(test);
		 * obj2.removeDuplicates(obj2); obj2.printList();
		 */
	}
}
