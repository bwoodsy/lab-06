package com.example.listycity20;

import static java.util.Objects.hash;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable{
    private String city;
    private String province;

    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    @Override
    /** This compares two cities by their names
     * @return -1 if the caller is greater than the argument
     * @return 0 if the caller is equal to the argument
     */
    public int compareTo(Object o){
        City city = (City) o; //typecasting
        return this.city.compareTo(city.getCityName());
    }

    /**
     * Overrides the default equals method. Two City objects are considered equal
     * if they have the same city name and province name.
     * @param o The object to compare against.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City cityObj = (City) o;
        // Use the correct field names: 'city' and 'province'
        return Objects.equals(this.city, cityObj.city) &&
                Objects.equals(this.province, cityObj.province);
    }

    /**
     * Overrides the default hashCode method. The hash code is generated based on
     * the city name and province name.
     * @return A hash code value for the object.
     */
    @Override
    public int hashCode() {
        // Use the correct field names: 'city' and 'province'
        return Objects.hash(city, province);
    }
}
