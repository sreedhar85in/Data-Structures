package com.arrays.learning.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class FoobarChallengeLevel1 {
	
	
	
	
	public static void main(String[] args) {
		
		final ArrayList<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, 1, 2, 3, 4, 5,5,4,8,8,10,10,10);
		Set<Integer> value = findDuplicates(list);
		System.out.println("The value of duplicates are " + value.toString());
		System.out.println(list.toString());
		int arr[] = {10, 20, 20, 10, 10, 20, 5, 20}; 
		int n = arr.length; 
		countFreq(arr,n);
		
		
		/*
		 * for(int i=0;i<=value.size();i++) { removeAll(list, value.); }
		 */
		
		/*
		 * for (int s : value) {
		 * 
		 * removeAll(list, s); }
		 * 
		 * System.out.println("THe final value of the list is ::" + list.toString());
		 */
		
	}
	
static int[] removefinal(int data[],  int n)   {
		
		int arrayLength = data.length; 
		
        System.out.println("The array length is :: " + arrayLength);
		

		 HashMap<Integer, Integer> mp3 = new HashMap<Integer, Integer>();

		for (int x : data) {

			mp3.put(x, mp3.getOrDefault(x, 0) + 1);

		}

		ArrayList<Integer> list2 = new ArrayList<Integer>();

		for (int i = 0; i < arrayLength; i++) {

			if ((mp3.containsKey(data[i]) && mp3.get(data[i]) > n)) {
				continue;
			}
			
				
			list2.add(data[i]);

		}

	int[]	arr9 = list2.stream().mapToInt(i -> i).toArray();
		//list2=null;
	//	mp3=null;
		arrayLength=0;
		return arr9;

	}
	
	
	
	
	public String Solution() {
		
		List<Integer> taskList = new ArrayList<Integer>();
		
		taskList.add(0,20356);
		taskList.add(1,20357);
		taskList.add(2,20358);
		
		
		return null;
	}
	
	private static <T> Set<T> findDuplicates(Collection<T> collection) {
	    Set<T> uniques = new HashSet<>();
	    return collection.stream()
	        .filter(e -> !uniques.add(e))
	        .collect(Collectors.toSet());
	}
	
	
	private static <T> Set<T> findDuplicatescustom(Collection<T> collection) {
	    Set<T> uniques = new HashSet<>();
	    return collection.stream()
	        .filter(e -> !uniques.add(e))
	        .collect(Collectors.toSet());
	}
	
	static void removeAll(List<Integer> list, int element) {
	    list.removeIf(n -> Objects.equals(n, element));
	}
	
	static void countFreq(int arr[], int n)  
    { 
        Map<Integer, Integer> mp = new HashMap<>(); 
  
        // Traverse through array elements and  
        // count frequencies  
        for (int i = 0; i < n; i++) 
        { 
            mp.put(arr[i], mp.get(arr[i]) == null ? 1 : mp.get(arr[i]) + 1); 
        } 
  
        // To print elements according to first  
        // occurrence, traverse array one more time  
        // print frequencies of elements and mark  
        // frequencies as -1 so that same element  
        // is not printed multiple times.  
        for (int i = 0; i < n; i++)  
        { 
            if (mp.get(arr[i]) != -1)  
            { 
                System.out.println(arr[i] + " " + mp.get(arr[i])); 
                mp.put(arr[i], -1); 
            } 
        } 
    } 
	
	

}
