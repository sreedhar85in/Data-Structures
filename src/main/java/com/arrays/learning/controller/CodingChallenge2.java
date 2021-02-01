package com.arrays.learning.controller;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CodingChallenge2 {

	public void printmessage() {

		for (int i = 1; i <= 100; i++) {

			if (i % 3 == 0 && i % 5 == 0) {

				System.out.println("SiteHost");

			}

			else if (i % 3 == 0) {

				System.out.println("Site");

			}

			else if (i % 5 == 0) {

				System.out.println("Host");

			}

			else {

				System.out.println(i);

			}

		}

	}

	static List<String> doThreeFive(int max) {
		
		List<String> list = new ArrayList<>();
		list.add("00657");
		list.add("");
		list.add("");
		
		
		
		{

			for (int i = 1; i <= max; i++) {

				if (i % 3 == 0 && i % 5 == 0) {

					list.add("threefive");

				}

				else if (i % 3 == 0) {

					list.add("three");

				}

				else if (i % 5 == 0) {

					list.add("five");

				}

				else {

					list.add(Integer.toString(i));

				}
				
				

			}

		}
		
		
	}
	
	 static String formatTime(int millis) {
	        
	        long minutes = (millis/1000)/60;
	        long seconds = (millis/1000)%60;
	       DecimalFormat df = new DecimalFormat("#.##");
	       df.setRoundingMode(RoundingMode.CEILING);
	        df.format(number)
	        return result;  
	    }

	public static void main(String[] args) {

		CodingChallenge2 obj = new CodingChallenge2();
		obj.printmessage();
		// CodingChallenge.printmessage();

	}

}
