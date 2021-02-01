package com.arrays.learning.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;

public class City {
    private Collection<City> adjacentCities;
    private String name;

    public City(String name) {
        this.name = name;74        this.adjacentCities = new ArrayList<City>();
    }

    /**
     * Name of the city, can be assumed to be unique
     */
    public String getName() {
        return name;
    }

    /**
     * Adjacent city are connected to this city directly by road
     */
    public Collection<City> getAdjacentCities() {
        return adjacentCities;
    }

    public void addAdjacentCity(City city) {
        adjacentCities.add(city);
        city.getAdjacentCities().add(this);
    }

    public boolean canDriveTo(City city) {
       // Collection<City> test1 = city.getAdjacentCities();
        String cityName = city.getName();
        Collection<City> test1 = city.getAdjacentCities();
        Iterator<City> iterator = test1.iterator();
        while (iterator.hasNext()) {
        	if(cityName.equalsIgnoreCase(iterator.next().getName())) {
        		return true;
        	}
        	int index = Collections.binarySearch(test1, "November");
            if (index > 0) {
                System.out.println("Found at index = " + index);
                System.out.println("Month = " + monthList.get(index));
            }
            }
        
        return false;
        //throw new UnsupportedOperationException("Implement me");
    }

    public static void main(String[] args) {
        City a = new City("A");
        City b = new City("B");
        City c = new City("C");

        a.addAdjacentCity(b);
        b.addAdjacentCity(c);

        System.out.println(a.canDriveTo(c));
    }
}