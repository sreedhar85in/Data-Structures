package com.arrays.learning.controller;

import java.awt.List;

import com.fasterxml.jackson.databind.ser.ContainerSerializer;

import springfox.documentation.service.Header;

public class SinglyLinkedListPractise9<T> {

	public class Node {

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

	public SinglyLinkedListPractise9() {
		this.headNode = null;
		this.size = 0;
	}

	public boolean isEmpty() {

		return this.headNode == null;
	}

	public void printList() {

		if (isEmpty()) {

			System.out.println("list is Empty");
		}

		System.out.println("List is : ");

		Node currentNode = this.headNode;

		while (currentNode != null) {
			System.out.println(currentNode.data.toString() + " -> ");
			currentNode = currentNode.nextNode;
		}

		System.out.println(currentNode.data.toString() + " -> null");
	}

	public void insertAtHead(T data) {

		Node newNode = new Node();
		newNode.data = data;
		newNode.nextNode = headNode;
		headNode = newNode;
		size++;
	}

	public void insertAtEnd(T data) {

		if (isEmpty()) {
			insertAtHead(data);
			return;
		}
		Node currentNode = this.headNode;
		while (currentNode.nextNode != null) {

			currentNode = currentNode.nextNode;
		}

		Node newNode = new Node();

		newNode.data = data;

		currentNode.nextNode = newNode;
		newNode.nextNode = null;
		size++;

	}

	public void insertAftervalue(T data, T previousData) {

		Node currentNode = this.headNode;

		while (currentNode != null) {

			if (currentNode.data.equals(previousData)) {
				Node newNode = new Node();
				newNode.data = data;
				newNode.nextNode = currentNode.nextNode;
				currentNode.nextNode = newNode;
				size++;

			}
		}

	}

	public void deleteAtHead() {
		if (isEmpty()) {
			return;
		}

		headNode = headNode.nextNode;
		size--;
	}

	public void deleteAtEnd() {

		if (isEmpty()) {
			return;
		}

		Node currentNode = this.headNode;
		Node prevNode = this.headNode;

		while (currentNode.nextNode != null) {

			prevNode = currentNode;
			currentNode = currentNode.nextNode;
		}

		prevNode.nextNode = null;
		size--;

	}

	public void deleteByValue(T data) {

		Node curreNode = this.headNode;
		Node prevNode = this.headNode;

		if (curreNode.data.equals(data)) {

			deleteAtHead();
			// return; no need of return if multiple same values are there.

		}

		while (curreNode != null) {
			if (curreNode.data.equals(data)) {
				prevNode.nextNode = curreNode.nextNode;
				size--;
				// return; no need of return fi multiple same values present to delete.
			}
			prevNode = curreNode;
			curreNode = curreNode.nextNode;
		}

	}

	public void reverse(SinglyLinkedListPractise9<T> list1) {

		SinglyLinkedListPractise9<T>.Node next = null;
		SinglyLinkedListPractise9<T>.Node current = list1.getHeadNode();
		SinglyLinkedListPractise9<T>.Node prev = null;

		while (current != null) {

			next = current.nextNode;
			current.nextNode = prev;
			prev = current;
			current = next;
		}

		list1.headNode = prev;

	}

	public boolean detectloop(SinglyLinkedListPractise9<T> list1) {

		SinglyLinkedListPractise9<T>.Node slow = list1.headNode;
		SinglyLinkedListPractise9<T>.Node fast = list1.headNode;

		while (slow != null && fast != null && fast.nextNode != null) {

			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;

			if (slow == fast) {

				return true;

			}

		}
		return false;

	}

	public Object findMiddle(SinglyLinkedListPractise9<T> list1) {

		SinglyLinkedListPractise9<T>.Node currentNode = list1.headNode;
		SinglyLinkedListPractise9<T>.Node midNode = list1.headNode;

		while (midNode != null && currentNode != null && currentNode.nextNode != null) {

			currentNode = currentNode.nextNode.nextNode;

			if (currentNode != null) {
				midNode = midNode.nextNode;
			}
		}

		return midNode.data;

	}

	public void removeDuplicates(SinglyLinkedListPractise9<T> list1) {

		SinglyLinkedListPractise9<T>.Node currentNode = list1.headNode; // outer loop
		SinglyLinkedListPractise9<T>.Node compareNode = null; // inner loop

		while (currentNode != null && currentNode.nextNode != null) {

			compareNode = currentNode;

			while (compareNode.nextNode != null) {

				if (currentNode.data.equals(compareNode.nextNode.data)) {

					compareNode.nextNode = compareNode.nextNode.nextNode;

				}

				else {

					compareNode = compareNode.nextNode;
				}
			}

			currentNode = currentNode.nextNode;

		}

	}

	public static <T> boolean contains(SinglyLinkedListPractise9<T> list1, T data) {

		SinglyLinkedListPractise9<T>.Node currentNode = list1.headNode;

		while (currentNode != null) {

			if (currentNode.data.equals(data)) {

				return true;
			}

			currentNode = currentNode.nextNode;

		}

		return false;
	}

	public static <T> SinglyLinkedListPractise9<T> Union(SinglyLinkedListPractise9<T> list1,
			SinglyLinkedListPractise9<T> list2) {

		if (list1.isEmpty()) {
			return list2;
		}

		if (list2.isEmpty()) {
			return list1;
		}

		SinglyLinkedListPractise9<T>.Node currentNode = list1.headNode;

		while (currentNode.nextNode != null) {
			currentNode = currentNode.nextNode;
		}

		currentNode.nextNode = list2.headNode;

		return list1;

	}

	public static <T> SinglyLinkedListPractise9<T> intersection(SinglyLinkedListPractise9<T> list1,
			SinglyLinkedListPractise9<T> list2) {

		SinglyLinkedListPractise9<T> result = new SinglyLinkedListPractise9<T>();

		if (list1.isEmpty() || list2.isEmpty()) {

			return result;
		}

		SinglyLinkedListPractise9<T>.Node currentNode = list1.getHeadNode();

		while (currentNode != null) {

			if (contains(list2, currentNode.data)) {

				result.insertAtHead(currentNode.data);

			}

			currentNode = currentNode.nextNode;
		}

		return result;
	}

	public static void main(String[] args) {

	}

}
