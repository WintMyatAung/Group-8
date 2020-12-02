package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import java.util.ArrayList;

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
        Country coutest = new Country();
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

    // Test city array manual.
    @Test
    void printCityTest()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City cttest = new City();
        cttest.setID(1);
        cttest.setName("Kabul");
        cttest.setCountryCode("AFG");
        cttest.setDistrict("Kabol");
        cttest.setPopulation(1780000);
        cities.add(cttest);
        app.outputCity(cities);
    }

    // Aung Khant Paing
    // Testing about the arraylist null.
    @Test
    void printCapitalCityTestNull()
    {
        app.outputCapitalCity(null);
    }

    //    Testing about the arraylist contains to be null.
    @Test
    void printCapitalCityTestContainsNull()
    {
        ArrayList<Capital_City> cap = new ArrayList<Capital_City>();
        cap.add(null);
        app.outputCapitalCity(cap);
    }

    //    Testing about the arraylist to be empty.
    @Test
    void printCapitalCityTestEmpty()
    {
        ArrayList<Capital_City> cap = new ArrayList<Capital_City>();
        app.outputCapitalCity(cap);
    }

    //    Testing about the arraylist.
    @Test
    void printCapitalCityTest()
    {
        ArrayList<Capital_City> cap = new ArrayList<Capital_City>();
        Capital_City captest = new Capital_City();
        captest.setcity_Name("New Delhi");
        captest.setcountry_Name("India");
        captest.setPopulation(301297);
        cap.add(captest);
        app.outputCapitalCity(cap);
    }

    // Aung Khant Paing
    // Testing about the arraylist null.
    @Test
    void printPopulationTestNull()
    {
        app.printPopulation(null);
    }

    //    Testing about the arraylist contains to be null.
    @Test
    void printPopulationTestContainsNull()
    {
        ArrayList<Population> pop = new ArrayList<Population>();
        pop.add(null);
        app.printPopulation(pop);
    }

    //    Testing about the arraylist to be empty.
    @Test
    void printPopulationTestEmpty()
    {
        ArrayList<Population> pop = new ArrayList<Population>();
        app.printPopulation(pop);
    }

    //    Testing about the arraylist.
    @Test
    void printPopulationTest()
    {
        ArrayList<Population> pop = new ArrayList<Population>();
        Population poptest = new Population();
        poptest.setName("Antarctica");
        poptest.setTotal(new BigInteger("0"));
        poptest.setCity(new BigInteger("0"));
        pop.add(poptest);
        app.printPopulation(pop);
    }

    // Aung Khant Paing
    // Testing about the arraylist null.
    @Test
    void printLanguageTestNull()
    {
        app.outputLanguage(null);
    }

    //    Testing about the arraylist contains to be null.
    @Test
    void printLanguageTestContainsNull()
    {
        ArrayList<Language> lang = new ArrayList<Language>();
        lang.add(null);
        app.outputLanguage(lang);
    }

    //    Testing about the arraylist to be empty.
    @Test
    void printLanguageTestEmpty()
    {
        ArrayList<Language> lang = new ArrayList<Language>();
        app.outputLanguage(lang);
    }

}
