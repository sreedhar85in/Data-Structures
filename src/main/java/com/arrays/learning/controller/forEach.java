package com.arrays.learning.controller;

import java.util.HashMap;
import java.util.Map;

public class forEach {
	
	
	public static void main(String[] arg) {
		forEach obj = new forEach();
		obj.testmethod();
		obj.testjava8foreachloop();
	}
	
	public void testmethod() {
	Map<String, Integer> items = new HashMap<>();
	
	items.put("A", 10);
	items.put("B", 20);
	items.put("C", 30);
	items.put("D", 40);
	items.put("E", 50);
	items.put("F", 60);
	items.put("F", 70);
	
	for(Map.Entry<String, Integer> entry : items.entrySet()) {
		System.out.println("Item :: " + entry.getKey() + " Count : " + entry.getValue());
		
	}
	
	}
	
	public void testjava8foreachloop() {
		
		Map<String, Integer> items = new HashMap<>();
		
		items.put("A", 20);
		items.put("B", 30);
		items.put("C", 40);
		items.put("E", 70);
		items.put("F", 90);
		
		items.forEach((k,v) -> System.out.println("Item :: " + k + " Count : " + v));
		
		items.forEach((k,v) -> {
			
			System.out.println("Item ::" + k + " Count : " + v);
			if(k.equals("E")) {
				System.out.println("Hello E ");
			}
			
		});
		
		
	}

}
