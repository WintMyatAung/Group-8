package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    // Aung Khant Paing
//    Testing about the arraylist null.
    @Test
    void printCountryTestNull()
    {
        app.PrintCountryList(null);
    }

//    Testing about the arraylist contains to be null.
    @Test
    void printCountryTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.PrintCountryList(countries);
    }

//    Testing about the arraylist to be empty.
    @Test
    void printCountryTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.PrintCountryList(countries);
    }

//    Testing about the arraylist.
    @Test
    void printCountryTest()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        com.napier.sem.Country coutest = new Country();
        coutest.setcode("ABW");
        coutest.setname("Aruba");
        coutest.setCon("North America");
        coutest.setReg("Caribbean");
        coutest.setPop(103000);
        coutest.setcap("Oranjestad");
        countries.add(coutest);
        app.PrintCountryList(countries);
    }

    // Shine Htet Oo
    @Test
    void printCityTestNull()
    {
        app.outputCity(null);
    }

    @Test
    void printCityTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.outputCity(cities);
    }

    @Test
    void printCityTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.outputCity(cities);
    }
}
