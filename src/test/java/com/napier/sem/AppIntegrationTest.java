package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33066");
    }

    // Wint Myat Aung [40478650]
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
        com.napier.sem.Country countrytest = new Country();
        countrytest.setcode("MMR");
        countrytest.setname("Myanmar");
        countrytest.setCon("Asia");
        countrytest.setReg("Southeast Asia");
        countrytest.setPop(45611000);
        countrytest.setcap("Rangoon");
        countries.add(countrytest);
        app.PrintCountryList(countries);
    }
    //Bhone Thet Aung//
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

    // Test city array manual.
    @Test
    void printCityTest()
    {
        ArrayList<City> cities = new ArrayList<City>();
        com.napier.sem.City cttest = new City();
        cttest.setID(2710);
        cttest.setName("Rangoon");
        cttest.setCountryCode("MMR");
        cttest.setDistrict("Rangoon");
        cttest.setPopulation(3361700);
        cities.add(cttest);
        app.outputCity(cities);
    }
}