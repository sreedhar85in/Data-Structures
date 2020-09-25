package com.arrays.learning.controller;

import java.util.LinkedList;
import java.util.Queue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InsertionBinaryTree {
	
	static Node root;
	static Node temp = root;
	
	public static void main(String[] args) {
		
		root= new Node(10);
		root.left = new Node(11);
		root.left.left = new Node(7);
		root.right = new Node(9);
		root.right.left=new Node(15);
		root.right.right = new Node(8);
		log.info("In order traversal before insertion");
		inorder(root);
		
		int value= 12;
		insert(root, value);
		
		log.info("Inorder traversal afte insertion : ");
		inorder(root);
		
	}
	
	
	public static class Node {
		
		int value;
		Node left;
		Node right;
		
		//constructor
		
		Node(int value){
			
			this.value = value;
			left = null;
			right = null;
		}
		
	}

	
	// In order traversal of a binary tree.
	static void inorder(Node temp)
	{
		
		if ( temp == null) {
			
			return;
		}
		
		inorder(temp.left);
		log.info(temp.value + " ");
		inorder(temp.right);
		
	}
	
	
	//function to insert element in binary tree
	
	static void insert(Node temp, int value) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(temp);
		
		//Do level order traversal until we find an empty place.
		
		while(!q.isEmpty()) {
			
			
			temp = q.peek();
			q.remove();
			
			if(temp.left == null) {
				
				temp.left = new Node(value);
				break;
			}
			
			else {
				q.add(temp.left);
			}
			
			if (temp.right == null) {
				
				temp.right = new Node(value);
				break;
			}
			else {
				q.add(temp.right);
			}
		}
		
		
	}
}
