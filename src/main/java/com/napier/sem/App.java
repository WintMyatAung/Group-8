package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{

    public static void main(String[] args) throws SQLException {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        //  Get the largest to smallest population by country
        ArrayList<country> country = a.getcountrydata();

        //  Get the largest to smallest population by country continent
        ArrayList<country> countrycc = a.getcountryContinentdata();

        //  Get the population of country region in order from largest to smallest
        ArrayList<country> region = a.getcountryregiondata();

        //  Get top 5 populated countries in the world
        ArrayList<country> pcountry_world = a.getPopulatedCountries_data();

        //  Get top 5 populated countries in a Continent
        ArrayList<country> pcountry_continent = a.getPopulatedCountriesContinent_data();

        //  Get top 5 populated countries in a Region
        ArrayList<country> pcountry_region = a.getPopulatedCountriesRegion_data();



        // output the country array list
        System.out.println("Table countries sorted by Largest Population to Smallest Population \n");
        a.PrintCountrylist(country);

        System.out.println("Table countries sorted by Largest Population to Smallest Population of a Continent \n");
        a.PrintCountrylist(countrycc);

        System.out.println("Table countries sorted by Largest Population to Smallest Population of a Region \n");
        a.PrintCountrylist(region);

        System.out.println("Top 5 populated countries in a Continent.......");
        a.PrintCountrylist(pcountry_continent);

        System.out.println("Top 5 populated countries in the world.......");
        a.PrintCountrylist(pcountry_world);

        System.out.println("Top 5 populated countries in a Region.......");
        a.PrintCountrylist(pcountry_region);



        //  Get the largest to smallest population by city
        ArrayList<city> city = a.showcity();

        //  Get the largest to smallest population by city continent
        ArrayList<city> citycontinent = a.showcitywithcontinent();

        // Output the city array list
        System.out.println("Table cities sorted by Largest Population to Smallest Population \n");
        a.outputcity(city);

        System.out.println("Table cities sorted by Largest Population to Smallest Population of a Continent \n");
        .outputcity(citycontinent);

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
     * Aung Khant Paing [40478639]
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
     * Aung Khant Paing[40478639]
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
            System.out.println("Failed to get Country details by Continent");
            return null;
        }
    }


    //  Bhone Thet Aung [40478627]  //
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
            System.out.println("Failed to get Country details by region");
            return null;
        }
    }

    public ArrayList<country> getPopulatedCountries_data() {

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String query ="select country.Code,country.Name,country.Continent,country.Region,country.Population,city.Name FROM country,city where country.Capital = city.ID order by country.Population desc limit 5";

            // Execute SQL statement
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<country> pcountry_world = new ArrayList<com.napier.sem.country>();
            while (rs.next())
            {
                com.napier.sem.country country = new country();
                country.code = rs.getString("country.Code");
                country.name = rs.getString("country.Name");
                country.Con = rs.getString("country.Continent");
                country.Reg = rs.getString("country.Region");
                country.Pop = rs.getInt("country.Population");
                country.cap = rs.getString("city.Name");
                pcountry_world.add(country);
            }
            return pcountry_world;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Populated Countries in details");
        }
        return null;
    }
    //  Bhone Thet Aung [40478627]  //


    //  Wint Myat Aung [40478650]  //
    //**  Get top 5 populated countries in a Continent  **//
    public ArrayList<country> getPopulatedCountriesContinent_data() {
        //  System.out.println("Top 5 populated countries in a continent.......");

        Scanner scan = new Scanner(System.in);
        //  System.out.print("Please enter a Continent: ");
        //  String Con = scan.nextLine();

        //  System.out.print("Enter the number to get the populated countries of a continent: ");
        //  num = scan.nextInt();

        scan.close();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String query ="select country.Code,country.Name,country.Continent,country.Region,country.Population,city.Name FROM country,city where country.Capital = city.ID and country.Continent = 'Asia' order by country.Population desc limit 5";
            boolean b = query instanceof String;
            System.out.println(b);

            // Execute SQL statement
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<country> pcountry_continent = new ArrayList<com.napier.sem.country>();
            while (rs.next())
            {
                com.napier.sem.country country = new country();
                country.code = rs.getString("country.Code");
                country.name = rs.getString("country.Name");
                country.Con = rs.getString("country.Continent");
                country.Reg = rs.getString("country.Region");
                country.Pop = rs.getInt("country.Population");
                country.cap = rs.getString("city.Name");
                pcountry_continent.add(country);
            }
            return pcountry_continent;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Populated Countries in details");
        }
        return null;
    }
    //** ---- **//


    //**  Get top 5 populated countries in a Region  **//
    public ArrayList<country> getPopulatedCountriesRegion_data() {
        Scanner scan = new Scanner(System.in);
        //  System.out.print("Please enter a Region: ");
        //  String Reg = scan.nextLine();

        //  System.out.print("Enter the number to get the populated countries of a Region: ");
        //  num = scan.nextInt();

        scan.close();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String query ="select country.Code,country.Name,country.Continent,country.Region,country.Population,city.Name FROM country,city where country.Capital = city.ID and country.Region = 'Southern and Central Asia' order by country.Population desc limit 5";

            // Execute SQL statement
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<country> pcountry_region = new ArrayList<com.napier.sem.country>();
            while (rs.next())
            {
                com.napier.sem.country country = new country();
                country.code = rs.getString("country.Code");
                country.name = rs.getString("country.Name");
                country.Con = rs.getString("country.Continent");
                country.Reg = rs.getString("country.Region");
                country.Pop = rs.getInt("country.Population");
                country.cap = rs.getString("city.Name");
                pcountry_region.add(country);
            }
            return pcountry_region;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Populated Countries in details");
        }
        return null;
    }
    //** ---- **//
    //  Wint Myat Aung [40478650]  //



    /**
     * Gets all the cities from city.java.
     */
    //  Shine Htet Oo [40478643]  //
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
            // Extract City information
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
            // Extract City information
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
            System.out.println("Failed to get city information by continent");
            return null;
        }
    }
    //  Shine Htet Oo [40478643]  //


    /**
     * Print a list of countries.
     * Aung Khant Paing [40478639]
     */
    public void PrintCountrylist (ArrayList<country> country)
    {
        // Print header
        System.out.println(String.format("%-5s %-50s %-15s %-30s %-25s %-20s","Code", "Name", "Continent", "Region", "Population", "Capital"));
        System.out.println(String.format("%-5s %-50s %-15s %-30s %-25s %-20s","----", "----", "---------", "------", "----------", "-------"));
        // Loop over all Country in the list
        for (com.napier.sem.country cou : country)
        {
            String countrystring = String.format("%-5s %-50s %-15s %-30s %-25s %-20s", cou.code, cou.name, cou.Con, cou.Reg, cou.Pop, cou.cap);
            System.out.println(countrystring);
        }
        for (int j = 1; j <= 25; j+=1)
        {
            System.out.print("--");
        }
        System.out.println("\n\n");
    }


    //  Shine Htet Oo [40478643]  //
    /**
     * Prints a list of cities
     */
    public void outputcity(ArrayList<city> city) {
        // Print header
        System.out.println(String.format("%-40s %-20s %-40s %-30s", "Name", "CountryCode", "District", "Population"));
        System.out.println(String.format("%-40s %-20s %-40s %-30s", "____", "___________", "________", "__________"));
        // Loop over all City in the list
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
        System.out.println("\n\n");
    }
}
