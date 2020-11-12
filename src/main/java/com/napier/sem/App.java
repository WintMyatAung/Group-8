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

        // output the country array list
        a.PrintCountrylist(country);
        a.PrintCountrylist(countrycc);

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
    public void PrintCountrylist (ArrayList<country> country)
    {
        // Print header
        System.out.println("Table contents sorted by Largest Population to Smallest Population \n");
        System.out.println(String.format("%-5s %-50s %-15s %-30s %-25s %-20s","Code", "Name", "Continent", "Region", "Population", "Capital"));
        System.out.println(String.format("%-5s %-50s %-15s %-30s %-25s %-20s","----", "----", "---------", "------", "----------", "-------"));
        // Loop over all Country in the list
        for (com.napier.sem.country cou : country)
        {
            String countrystring = String.format("%-5s %-50s %-15s %-30s %-25s %-20s", cou.code, cou.name, cou.Con, cou.Reg, cou.Pop, cou.cap);
            System.out.println(countrystring);
        }
        System.out.println("----XXX----");
    }
}
