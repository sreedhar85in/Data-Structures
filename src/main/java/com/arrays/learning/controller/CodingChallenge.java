package com.arrays.learning.controller;

public class CodingChallenge {

	public  void printmessage() {

		

		for (int i=1; i<=100; i++) {
			
			if (i % 3 == 0 && i % 5 == 0) {

				System.out.println("SiteHost");

			}

			else if (i % 3 == 0 ) {

				System.out.println("Site");

			}

			else if(i % 5 == 0 ) {

				System.out.println("Host");

			}

			else {

			System.out.println(i);
			
			}

		}

	}

	public static void main(String[] args) {
		
		CodingChallenge obj = new CodingChallenge();
		obj.printmessage();
		//CodingChallenge.printmessage();

	}

}
