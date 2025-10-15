package com.example.listycity20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * @throws IllegalArgumentException if the city already exists in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This checks if a city exists in the list
     * @param city
     * @return true if the city exists in the list, false otherwise
     */
    public boolean hasCity(City city){
        return cities.contains(city);
    }

    /**
     * This deletes a city from the list
     * @param city
     * @throws IllegalArgumentException if the city does not exist in the list
     */
    public void delete(City city){
        if (cities.contains(city)){
            cities.remove(city);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This counts the number of cities in the list
     * @return the number of cities in the list
     */
    public int countCities(){
        return cities.size();
    }
}
