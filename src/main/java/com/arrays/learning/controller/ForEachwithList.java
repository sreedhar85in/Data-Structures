package com.arrays.learning.controller;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ForEachwithList {
	
	
public static void main(String[] args) {
	
	ForEachwithList obj = new ForEachwithList();
	obj.foreachwithlistmethod1();
	
}


public void foreachwithlistmethod1() {
	
	List <String> items = new ArrayList<>();
	items.add("A");
	items.add("B");
	items.add("C");
	items.add("D");
	items.add("E");
	
	items.forEach(item -> System.out.println(item));
	
	System.out.println("---------------------------------------------------------");
	log.info("Info");
	log.debug("Debug");
	log.error("Error");
	log.warn("warning");
	
	items.forEach(item -> {
		if("C".equals(item))
				{
			
			System.out.println(item);
				}
		
	});
	
	System.out.println("---------------------------------------------------------");
	
	items.forEach(System.out::println);
	
	System.out.println("---------------------------------------------------------");
	
	
	items.stream()
		.filter(itemdonk ->itemdonk.contains("B"))
		.forEach(System.out::println);
	
	
	System.out.println("---------------------------------------------------------");
}



}
