package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App
{

    public static void main(String[] args) throws SQLException {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Get the largest to smallest population by country
        ArrayList<country> country = a.getcountrydata();

        // Get the largest to smallest population by country continent
        ArrayList<country> countrycc = a.getcountryContinentdata();

        //Get the population of country region in order from largest to smallest
        ArrayList<country> region = a.getcountryregiondata();

        // output the country array list
        a.PrintCountrylist(country);
        a.PrintCountrylist(countrycc);
        a.PrintCountrylist(region);

        // Extract city and city continent information
        ArrayList<city> city = a.showcity();
        ArrayList<city> citycontinent = a.showcitywithcontinent();

        // Call output function
        a.outputcity(city);
        a.outputcity(citycontinent);


        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "Group8");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
    /**
     * Gets all the countries.
     */
    public ArrayList<country> getcountrydata()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String query ="select country.Code,country.Name,country.Continent,country.Region,country.Population,city.Name from country,city where country.Capital = city.ID order by country.Population DESC, country.Name";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(query);
            // Extract Country detail information
            ArrayList<country> country = new ArrayList<com.napier.sem.country>();
            while (rset.next())
            {
                com.napier.sem.country cou = new country();
                cou.code = rset.getString("country.Code");
                cou.name = rset.getString("country.Name");
                cou.Con = rset.getString("country.Continent");
                cou.Reg = rset.getString("country.Region");
                cou.Pop = rset.getInt("country.Population");
                cou.cap = rset.getString("city.Name");
                country.add(cou);
            }
            return country;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country details");
            return null;
        }
    }
    /**
     * Gets all the countries with continent.
     */
    public ArrayList<country> getcountryContinentdata()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String query1 ="select country.Code,country.Name,country.Continent,country.Region,country.Population,city.Name from country,city where country.Capital = city.ID and country.Continent = 'Asia' order by country.Population DESC, country.Name";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(query1);
            // Extract Country detail information
            ArrayList<country> country = new ArrayList<com.napier.sem.country>();
            while (rset.next())
            {
                com.napier.sem.country cou = new country();
                cou.code = rset.getString("country.Code");
                cou.name = rset.getString("country.Name");
                cou.Con = rset.getString("country.Continent");
                cou.Reg = rset.getString("country.Region");
                cou.Pop = rset.getInt("country.Population");
                cou.cap = rset.getString("city.Name");
                country.add(cou);
            }
            return country;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country details");
            return null;
        }
    }
    /**
     * Gets all the countries with region.
     */
    public ArrayList<country> getcountryregiondata()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String query ="select country.Code,country.Name,country.Continent,country.Region,country.Population,city.Name from country,city where country.Capital = city.ID and country.Region = 'Southeast Asia' order by country.Population DESC, country.Name";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(query);
            // Extract Country detail information
            ArrayList<country> country = new ArrayList<com.napier.sem.country>();
            while (rset.next())
            {
                com.napier.sem.country cou = new country();
                cou.code = rset.getString("country.Code");
                cou.name = rset.getString("country.Name");
                cou.Con = rset.getString("country.Continent");
                cou.Reg = rset.getString("country.Region");
                cou.Pop = rset.getInt("country.Population");
                cou.cap = rset.getString("city.Name");
                country.add(cou);
            }
            return country;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country details");
            return null;
        }
    }
    /**
     * Gets all the cities from city.java.
     */
    public ArrayList<city> showcity()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT * FROM city ORDER BY Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<city> city = new ArrayList<city>();
            while (rset.next())
            {
                city ct = new city();
                ct.ID = rset.getInt("ID");
                ct.Name = rset.getString("Name");
                ct.CountryCode = rset.getString("CountryCode");
                ct.District = rset.getString("District");
                ct.Population = rset.getInt("Population");
                city.add(ct);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city");
            return null;
        }
    }
    /**
     * Gets all the cities with country continent.
     */
    public ArrayList<city> showcitywithcontinent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Code, country.Continent " +
                    " FROM city,country WHERE city.CountryCode = country.Code and country.Continent = 'Asia' " +
                    "ORDER BY city.Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<city> city = new ArrayList<city>();
            while (rset.next())
            {
                city ct = new city();
                ct.ID = rset.getInt("city.ID");
                ct.Name = rset.getString("city.Name");
                ct.CountryCode = rset.getString("city.CountryCode");
                ct.District = rset.getString("city.District");
                ct.Population = rset.getInt("city.Population");
                city.add(ct);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city");
            return null;
        }
    }
    /**
     * Print a list of countries.
     */
    public void PrintCountrylist (ArrayList<country> country)
    {
        // Print header
        System.out.println("Table countries sorted by Largest Population to Smallest Population \n");
        System.out.println(String.format("%-5s %-50s %-15s %-30s %-25s %-20s","Code", "Name", "Continent", "Region", "Population", "Capital"));
        System.out.println(String.format("%-5s %-50s %-15s %-30s %-25s %-20s","----", "----", "---------", "------", "----------", "-------"));
        // Loop over all Country in the list
        for (com.napier.sem.country cou : country)
        {
            String countrystring = String.format("%-5s %-50s %-15s %-30s %-25s %-20s", cou.code, cou.name, cou.Con, cou.Reg, cou.Pop, cou.cap);
            System.out.println(countrystring);
        }
        System.out.println("----XXX----\n\n");
    }
    /**
     * Prints a list of cities
     */
    public void outputcity(ArrayList<city> city) {
        // Print header
        System.out.println("Table cities are sorted by Largest Population to Smallest Population \n");
        System.out.println(String.format("%-40s %-20s %-40s %-30s", "Name", "CountryCode", "District", "Population"));
        System.out.println(String.format("%-40s %-20s %-40s %-30s", "____", "___________", "________", "__________"));
        // Loop over all employees in the list
        for (city ct : city) {
            String ct_string =
                    String.format("%-40s %-20s %-40s %-30s",
                            ct.Name, ct.CountryCode, ct.District, ct.Population);
            System.out.println(ct_string);
        }
        for (int i = 1; i <= 25; i = i +1)
        {
            System.out.print("--");
        }
    }
}
