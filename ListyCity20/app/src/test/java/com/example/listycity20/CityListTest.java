package com.example.listycity20;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        assertTrue(cityList.hasCity(mockCity()));
        assertFalse(cityList.hasCity(new City("Regina", "Saskatchewan")));
    }

    @Test
    void testDelete(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        cityList.delete(mockCity());
        assertEquals(0, cityList.getCities().size());
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(new City("Regina", "Saskatchewan"));
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        cityList.add(new City("Regina", "Saskatchewan"));
        assertEquals(2, cityList.countCities());
        cityList.delete(mockCity());
        assertEquals(1, cityList.countCities());
        cityList.delete(new City("Regina", "Saskatchewan"));
        assertEquals(0, cityList.countCities());
    }
}
