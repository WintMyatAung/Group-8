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
        ArrayList<Country> country = a.getCountryData();

        //  Get the largest to smallest population by country continent
        ArrayList<Country> countrycc = a.getCountryContinentData();

        //  Get the population of country region in order from largest to smallest
        ArrayList<Country> region = a.getCountryRegionData();

        //  Get top 5 populated countries in the world
        ArrayList<Country> pcountry_world = a.getPopulatedCountries_data();

        //  Get top 5 populated countries in a Continent
        ArrayList<Country> pcountry_continent = a.getPopulatedCountriesContinent_data();

        //  Get top 5 populated countries in a Region
        ArrayList<Country> pcountry_region = a.getPopulatedCountriesRegion_data();



        // output the country array list
        System.out.println("Table countries sorted by Largest Population to Smallest Population \n");
        a.PrintCountryList(country);

        System.out.println("Table countries sorted by Largest Population to Smallest Population of a Continent \n");
        a.PrintCountryList(countrycc);

        System.out.println("Table countries sorted by Largest Population to Smallest Population of a Region \n");
        a.PrintCountryList(region);

        System.out.println("Top 5 populated countries in the world.......");
        a.PrintCountryList(pcountry_world);

        System.out.println("Top 5 populated countries in a Continent.......");
        a.PrintCountryList(pcountry_continent);

        System.out.println("Top 5 populated countries in a Region.......");
        a.PrintCountryList(pcountry_region);



        //  Get the largest to smallest population by city
        ArrayList<City> city = a.showCity();

        //  Get the largest to smallest population by city continent
        ArrayList<City> citycontinent = a.showCityWithContinent();

        //  Get top 5 populated city listed by country name
        ArrayList<City> cityname = a.showCityWithCountryNameTop();

        //  Get top 5 populated city listed by city District
        ArrayList<City> citydistrict = a.showCityWithDistrictTop();

        //  Get top 5 populated city listed by country continent
        ArrayList<City> citycontinenttop = a.showCityWithContinentTop();

        //  Get top 5 populated city listed by country region
        ArrayList<City> cityregion = a.showCityWithRegionTop();

        // Output the city array list
        System.out.println("Table cities sorted by Largest Population to Smallest Population \n");
        a.outputCity(city);

        System.out.println("Table cities sorted by Largest Population to Smallest Population of a Continent \n");
        a.outputCity(citycontinent);

        System.out.println("Top 5 populated city listed by country name \n");
        a.outputCity(cityname);

        System.out.println("Top 5 populated city listed by city District \n");
        a.outputCity(citydistrict);

        System.out.println("Top 5 populated city listed by country continent \n");
        a.outputCity(citycontinenttop);

        System.out.println("Top 5 populated city listed by country region \n");
        a.outputCity(cityregion);

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
    public ArrayList<Country> getCountryData()
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
            ArrayList<Country> country = new ArrayList<com.napier.sem.Country>();
            while (rset.next())
            {
                com.napier.sem.Country cou = new Country();
                cou.setcode(rset.getString("country.Code"));
                cou.setname(rset.getString("country.Name"));
                cou.setCon(rset.getString("country.Continent"));
                cou.setReg(rset.getString("country.Region"));
                cou.setPop(rset.getInt("country.Population"));
                cou.setcap(rset.getString("city.Name"));
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
    public ArrayList<Country> getCountryContinentData()
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
            ArrayList<Country> country = new ArrayList<com.napier.sem.Country>();
            while (rset.next())
            {
                com.napier.sem.Country cou = new Country();
                cou.setcode(rset.getString("country.Code"));
                cou.setname(rset.getString("country.Name"));
                cou.setCon(rset.getString("country.Continent"));
                cou.setReg(rset.getString("country.Region"));
                cou.setPop(rset.getInt("country.Population"));
                cou.setcap(rset.getString("city.Name"));
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
    public ArrayList<Country> getCountryRegionData()
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
            ArrayList<Country> country = new ArrayList<com.napier.sem.Country>();
            while (rset.next())
            {
                com.napier.sem.Country cou = new Country();
                cou.setcode(rset.getString("country.Code"));
                cou.setname(rset.getString("country.Name"));
                cou.setCon(rset.getString("country.Continent"));
                cou.setReg(rset.getString("country.Region"));
                cou.setPop(rset.getInt("country.Population"));
                cou.setcap(rset.getString("city.Name"));
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

    public ArrayList<Country> getPopulatedCountries_data() {

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String query ="select country.Code,country.Name,country.Continent,country.Region,country.Population,city.Name FROM country,city where country.Capital = city.ID order by country.Population desc limit 5";

            // Execute SQL statement
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Country> pcountry_world = new ArrayList<com.napier.sem.Country>();
            while (rs.next())
            {
                com.napier.sem.Country country = new Country();
                country.setcode(rs.getString("country.Code"));
                country.setname(rs.getString("country.Name"));
                country.setCon(rs.getString("country.Continent"));
                country.setReg(rs.getString("country.Region"));
                country.setPop(rs.getInt("country.Population"));
                country.setcap(rs.getString("city.Name"));
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
    public ArrayList<Country> getPopulatedCountriesContinent_data() {
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

            ArrayList<Country> pcountry_continent = new ArrayList<com.napier.sem.Country>();
            while (rs.next())
            {
                com.napier.sem.Country country = new Country();
                country.setcode(rs.getString("country.Code"));
                country.setname(rs.getString("country.Name"));
                country.setCon(rs.getString("country.Continent"));
                country.setReg(rs.getString("country.Region"));
                country.setPop(rs.getInt("country.Population"));
                country.setcap(rs.getString("city.Name"));
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
    public ArrayList<Country> getPopulatedCountriesRegion_data() {
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

            ArrayList<Country> pcountry_region = new ArrayList<com.napier.sem.Country>();
            while (rs.next())
            {
                com.napier.sem.Country country = new Country();
                country.setcode(rs.getString("country.Code"));
                country.setname(rs.getString("country.Name"));
                country.setCon(rs.getString("country.Continent"));
                country.setReg(rs.getString("country.Region"));
                country.setPop(rs.getInt("country.Population"));
                country.setcap(rs.getString("city.Name"));
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
    public ArrayList<City> showCity()
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
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {
                City ct = new City();
                ct.setID(rset.getInt("ID"));
                ct.setName(rset.getString("Name"));
                ct.setCountryCode(rset.getString("CountryCode"));
                ct.setDistrict(rset.getString("District"));
                ct.setPopulation(rset.getInt("Population"));
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
    public ArrayList<City> showCityWithContinent()
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
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {
                City ct = new City();
                ct.setID(rset.getInt("city.ID"));
                ct.setName(rset.getString("city.Name"));
                ct.setCountryCode(rset.getString("city.CountryCode"));
                ct.setDistrict(rset.getString("city.District"));
                ct.setPopulation(rset.getInt("city.Population"));
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
     * Gets all the cities with country Name Top 5.
     * Aung Khant Paing [40478639]
     */
    public ArrayList<City> showCityWithCountryNameTop()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population FROM city,country WHERE city.CountryCode = country.Code and country.Name = 'China'  ORDER BY city.Population DESC limit 5 ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract City information
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {
                City ct = new City();
                ct.setID(rset.getInt("city.ID"));
                ct.setName(rset.getString("city.Name"));
                ct.setCountryCode(rset.getString("city.CountryCode"));
                ct.setDistrict(rset.getString("city.District"));
                ct.setPopulation(rset.getInt("city.Population"));
                city.add(ct);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city information by country name");
            return null;
        }
    }

    /**
     * Gets all the cities with City District Top 5.
     * Aung Khant Paing [40478639]
     */
    public ArrayList<City> showCityWithDistrictTop()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT ID, Name, CountryCode, District, Population FROM city WHERE District = 'Liaoning' ORDER BY Population DESC limit 5 ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract City information
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {
                City ct = new City();
                ct.setID(rset.getInt("city.ID"));
                ct.setName(rset.getString("city.Name"));
                ct.setCountryCode(rset.getString("city.CountryCode"));
                ct.setDistrict(rset.getString("city.District"));
                ct.setPopulation(rset.getInt("city.Population"));
                city.add(ct);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city information by City District");
            return null;
        }
    }

    /**
     * Gets all the cities with country continent Top 5.
     */
    public ArrayList<City> showCityWithContinentTop()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population FROM city,country WHERE city.CountryCode = country.Code and country.Continent = 'Asia'  ORDER BY city.Population DESC limit 5 ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract City information
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {
                City ct = new City();
                ct.setID(rset.getInt("city.ID"));
                ct.setName(rset.getString("city.Name"));
                ct.setCountryCode(rset.getString("city.CountryCode"));
                ct.setDistrict(rset.getString("city.District"));
                ct.setPopulation(rset.getInt("city.Population"));
                city.add(ct);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city information by country name");
            return null;
        }
    }

    /**
     * Gets all the cities with country Region Top 5.
     */
    public ArrayList<City> showCityWithRegionTop()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population FROM city,country WHERE city.CountryCode = country.Code and country.Region = 'Central Africa'  ORDER BY city.Population DESC limit 5 ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract City information
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {
                City ct = new City();
                ct.setID(rset.getInt("city.ID"));
                ct.setName(rset.getString("city.Name"));
                ct.setCountryCode(rset.getString("city.CountryCode"));
                ct.setDistrict(rset.getString("city.District"));
                ct.setPopulation(rset.getInt("city.Population"));
                city.add(ct);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city information by country name");
            return null;
        }
    }

    /**
     * Print a list of countries.
     * Aung Khant Paing [40478639]
     */
    public void PrintCountryList(ArrayList<Country> country)
    {
        // Print header
        System.out.println(String.format("%-5s %-50s %-15s %-30s %-25s %-20s","Code", "Name", "Continent", "Region", "Population", "Capital"));
        System.out.println(String.format("%-5s %-50s %-15s %-30s %-25s %-20s","----", "----", "---------", "------", "----------", "-------"));
        // Loop over all Country in the list
        for (com.napier.sem.Country cou : country)
        {
            String code = cou.getcode();
            String name = cou.getname();
            String Con = cou.getCon();
            String Reg = cou.getReg();
            int Pop = cou.getPop();
            String cap = cou.getcap();
            String countrystring = String.format("%-5s %-50s %-15s %-30s %-25s %-20s", code, name, Con, Reg, Pop, cap);
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
    public void outputCity(ArrayList<City> city) {
        // Print header
        System.out.println(String.format("%-40s %-20s %-40s %-30s", "Name", "CountryCode", "District", "Population"));
        System.out.println(String.format("%-40s %-20s %-40s %-30s", "____", "___________", "________", "__________"));
        // Loop over all City in the list
        for (City ct : city) {
            String Name = ct.getName();
            String CountryCode = ct.getCountryCode();
            String District = ct.getDistrict();
            int Population = ct.getPopulation();
            String ct_string =
                    String.format("%-40s %-20s %-40s %-30s",
                            Name, CountryCode, District, Population);
            System.out.println(ct_string);
        }
        for (int i = 1; i <= 25; i = i +1)
        {
            System.out.print("--");
        }
        System.out.println("\n\n");
    }
}
