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
    @Test
    void printCountryTestNull()
    {
        app.PrintCountryList(null);
    }

    @Test
    void printCountryTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.PrintCountryList(countries);
    }

    @Test
    void printCountryTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.PrintCountryList(countries);
    }
}
