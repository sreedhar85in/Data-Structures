package com.arrays.learning.service;

import org.springframework.stereotype.Service;

@Service
public class ArrayService {

	public String reverse(String name) {
		
		
		char[] result = name.toCharArray();
		int startingIndex = 0;
		int endingIndex = result.length-1;
		char temp;
		
		for (;endingIndex > startingIndex; startingIndex++, endingIndex--) {
			
			temp = result[startingIndex];
			result[startingIndex] = result[endingIndex];
			result[endingIndex] = temp;
			
			
			
		}
		
		return new String(result);
		
		
		
	}

}
