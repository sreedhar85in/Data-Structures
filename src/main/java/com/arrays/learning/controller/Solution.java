package com.arrays.learning.controller;

/* 
Pets need people

*/

public class Solution {
    public static void main(String[] args) {
    	 Woman obj4 = new Woman();
       Cat obj1 = new Cat();
       obj1.owner = obj4;
       Dog obj2 = new Dog();
       obj2.owner = obj4;
       Fish obj3 = new Fish();
       obj3.owner = obj4;
      
    }

    public static class Cat {
        public Woman owner;
    }

    public static class Dog {
        public Woman owner;
    }

    public static class Fish {
        public Woman owner;
    }

    public static class Woman {
    }
}
