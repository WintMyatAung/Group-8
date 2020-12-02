package com.napier.sem;

import java.sql.*;
import java.util.*;
import java.math.*;

public class App
{

    public static void main(String[] args) throws SQLException {
        // Create new Application
        App a = new App();

        // Connect to database
        if (args.length < 1)
        {
            a.connect("localhost:3306");
        }
        else
        {
            a.connect(args[0]);
        }

        //  Get the largest to smallest population by country
        ArrayList<Country> countryWorld = a.getCountryData();

        //  Get the largest to smallest population by country continent
        ArrayList<Country> countryContinent = a.getCountryContinentData();

        //  Get the population of country region in order from largest to smallest
        ArrayList<Country> countryRegion = a.getCountryRegionData();

        //  Get top 5 populated countries in the world
        ArrayList<Country> pcountry_world = a.getPopulatedCountries_data();

        //  Get top 5 populated countries in a Continent
        ArrayList<Country> pcountry_continent = a.getPopulatedCountriesContinent_data();

        //  Get top 5 populated countries in a Region
        ArrayList<Country> pcountry_region = a.getPopulatedCountriesRegion_data();


        // output the country array list
        System.out.println("^^^ All the countries in the world organised by largest population to smallest ^^^\n");
        a.PrintCountryList(countryWorld);

        System.out.println("^^^ All the countries in a continent organised by largest population to smallest ^^^\n");
        a.PrintCountryList(countryContinent);

        System.out.println("^^^ All the countries in a region organised by largest population to smallest ^^^\n");
        a.PrintCountryList(countryRegion);

        System.out.println("^^^ Top 5 populated countries in the world ^^^\n");
        a.PrintCountryList(pcountry_world);

        System.out.println("^^^ Top 5 populated countries in a Continent ^^^\n");
        a.PrintCountryList(pcountry_continent);

        System.out.println("^^^ Top 5 populated countries in a Region ^^^\n");
        a.PrintCountryList(pcountry_region);


        //  Get the largest to smallest population by city
        ArrayList<City> cityWorld = a.showCity();

        //  Get the largest to smallest population by city continent
        ArrayList<City> cityContinent = a.showCityWithContinent();

        //  Get populated city listed by country name
        ArrayList<City> cityCountryName = a.showCityCountryName();

        //  Get populated city listed by country region
        ArrayList<City> cityCountryRegion = a.showCityCountryRegion();

        //  Get the largest to smallest population by city District
        ArrayList<City> cities_district = a.showCityWithDistrict();

        //  Get top 5 populated city in the world
        ArrayList<City> pcity_world = a.showCityWithPopulation();

        //  Get top 5 populated city listed by country continent
        ArrayList<City> cityContinentTop = a.showCityWithContinentTop();

        //  Get top 5 populated city listed by country region
        ArrayList<City> cityRegionTop = a.showCityWithRegionTop();

        //  Get top 5 populated city listed by country name
        ArrayList<City> cityNameTop = a.showCityWithCountryNameTop();

        //  Get top 5 populated city listed by city District
        ArrayList<City> cityDistrictTop = a.showCityWithDistrictTop();

        // Output the city array list
        System.out.println("### All the cities in the world organised by largest population to smallest ###\n");
        a.outputCity(cityWorld);

        System.out.println("### All the cities in a continent organised by largest population to smallest ###\n");
        a.outputCity(cityContinent);

        System.out.println("### All the cities in a region organised by largest population to smallest ###\n");
        a.outputCity(cityCountryRegion);

        System.out.println("### All the cities in a country organised by largest population to smallest ###\n");
        a.outputCity(cityCountryName);

        System.out.println("### All the cities in a district organised by largest population to smallest ###\n");
        a.outputCity(cities_district);

        System.out.println("### Top 5 populated city in the world ###\n");
        a.outputCity(pcity_world);

        System.out.println("### Top 5 populated city listed by country continent ###\n");
        a.outputCity(cityContinentTop);

        System.out.println("### Top 5 populated city listed by country region ###\n");
        a.outputCity(cityRegionTop);

        System.out.println("### Top 5 populated city listed by country name ###\n");
        a.outputCity(cityNameTop);

        System.out.println("### Top 5 populated city listed by city District ###\n");
        a.outputCity(cityDistrictTop);


        // Gets top 5 populated capital cities in a continent
        ArrayList<Capital_City> CapitalCities_continent = a.getTop5PopulatedCapitalCityWithContinent();

        // Gets populated capital cities in a World
        ArrayList<Capital_City> capitalCitiesWorld = a.getPopulatedCapitalCity();

        // Gets populated capital cities in a Continent
        ArrayList<Capital_City> capitalCitiesContinent = a.getPopulatedCapitalCityContinent();

        // Gets populated capital cities in a Region
        ArrayList<Capital_City> capitalCitiesRegion = a.getPopulatedCapitalCityRegion();

        // Gets top 5 populated capital cities in a World
        ArrayList<Capital_City> capitalCities_World = a.getTop5PopulatedCapitalCityWorld();

        // Gets top 5 populated capital cities in a region
        ArrayList<Capital_City> CapitalCities_region = a.getTop5PopulatedCapitalCityWithRegion();

        // Output the Capital city array list
        System.out.println("All the capital cities in the world organised by largest population to smallest....... \n");
        a.outputCapitalCity(capitalCitiesWorld);

        System.out.println("All the capital cities in a continent organised by largest population to smallest....... \n");
        a.outputCapitalCity(capitalCitiesContinent);

        System.out.println("All the capital cities in a region organised by largest to smallest....... \n");
        a.outputCapitalCity(capitalCitiesRegion);

        System.out.println("Top 5 populated capital cities in a World....... \n");
        a.outputCapitalCity(capitalCities_World);

        System.out.println("Top 5 populated capital cities in a continent....... \n");
        a.outputCapitalCity(CapitalCities_continent);

        System.out.println("Top 5 populated capital cities in a region....... \n");
        a.outputCapitalCity(CapitalCities_region);


        // Get the population of people, people living in cities, and people not living in cities in each continent.
        ArrayList<Population> continentPopulation = a.livingCityInContinent();

        // Get the population of people, people living in cities, and people not living in cities in each region.
        ArrayList<Population> regionPopulation = a.livingCityInRegion();

        // Get the population of people, people living in cities, and people not living in cities in each country.
        ArrayList<Population> countryPopulation = a.livingCityInCountry();

        // Output the population of people, people living in cities, and people not living in cities
        System.out.println("*** The population of people, people living in cities, and people not living in cities in each continent ***\n\n");
        a.printPopulation(continentPopulation);

        System.out.println("*** The population of people, people living in cities, and people not living in cities in each region ***\n\n");
        a.printPopulation(regionPopulation);

        System.out.println("*** The population of people, people living in cities, and people not living in cities in each country ***\n\n");
        a.printPopulation(countryPopulation);


        // Get the total world Population
        BigInteger world = a.getWorldPopulation();

        // Get the total Asia continent Population
        BigInteger continent = a.getContinentPopulation();

        // Get the total Southeast Asia region Population
        BigInteger region = a.getRegionPopulation();

        // Get the total Egypt Country Population
        BigInteger country = a.getCountryPopulation();

        // Get the total Rio Grande do Sul district Population
        BigInteger district = a.getDistrictPopulation();

        // Get the total Los Angeles city population
        BigInteger city = a.getCityPopulation();

        // Output the Population information
        System.out.println("Population Report !!! \n");

        System.out.println("The population of the world is "+ world +".");

        System.out.println("The population of a continent (Asia) is "+ continent +".");

        System.out.println("The population of a region (Southeast Asia) is "+ region +".");

        System.out.println("The population of a country (Egypt) is "+ country +".");

        System.out.println("The population of a district (Rio Grande do Sul) is "+ district +".");

        System.out.println("The population of a city (Los Angeles) is "+ city +".");
        for (int i = 1; i <= 50; i = i +1)
        {
            System.out.print("xx");
        }
        System.out.println("\n");

        // Get percentagelanguage.
        ArrayList<Language> getlanguage = a.getLanguagePercentage();

        System.out.println("Most used Languages and world population percentage \n");
        a.outputLanguage(getlanguage);

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
    public void connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
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
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "Group8");
                System.out.println("Successfully connected\n\n");
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
    **/
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
    **/
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


    /**
     * Gets all the countries with region.
     * Bhone Thet Aung [40478627]
    **/
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


    /**
     * Get top 5 populated countries in the world
     * Bhone Thet Aung [40478627]
    **/
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


    /**
     * Get top 5 populated countries in a Continent
     * Wint Myat Aung [40478650]
    **/
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


    /**
     * Get top 5 populated countries in a Region
     * Wint Myat Aung [40478650]
    **/
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


    /**
     * Gets all the cities from city.java.
     * Shine Htet Oo [40478643]
    **/
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
     * Shine Htet Oo [40478643]
    **/
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


    /**
     * Get populated city listed by country region
     * Bhone Thet Aung [40478627]
    **/
    public ArrayList<City> showCityCountryRegion()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population FROM city,country WHERE city.CountryCode = country.Code and country.Region = 'Southeast Asia'  ORDER BY city.Population DESC";
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
            System.out.println("Failed to get city information by region");
            return null;
        }
    }


    /**
     * Get populated city listed by country name
     * Bhone Thet Aung [40478627]
    **/
    public ArrayList<City> showCityCountryName()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population FROM city,country WHERE city.CountryCode = country.Code and country.Name = 'Thailand'  ORDER BY city.Population DESC ";
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
            System.out.println("Failed to get city information by name");
            return null;
        }
    }


    /**
     * Gets all the cities in a district organised by largest population to smallest.
     * Wint Myat Aung [40478650]
    **/
    public ArrayList<City> showCityWithDistrict() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String query = "select ID,Name,CountryCode,District,Population FROM city where District='Kabol' order by Population desc";

            // Execute SQL statement
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<City> cities_district = new ArrayList<City>();
            while (rs.next()) {
                City cities = new City();
                cities.setID(rs.getInt("ID"));
                cities.setName(rs.getString("Name"));
                cities.setCountryCode(rs.getString("CountryCode"));
                cities.setDistrict(rs.getString("District"));
                cities.setPopulation(rs.getInt("Population"));
                cities_district.add(cities);
            }
            return cities_district;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Populated Cities in details");
        }
        return null;
    }


    /**
     * Gets top 5 populated cities in the world........
     * Wint Myat Aung [40478650]
    **/
    public ArrayList<City> showCityWithPopulation() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String query = "select ID,Name,CountryCode,District,Population FROM city order by Population desc limit 5";

            // Execute SQL statement
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<City> pcity_world = new ArrayList<City>();
            while (rs.next()) {
                City cities = new City();
                cities.setID(rs.getInt("ID"));
                cities.setName(rs.getString("Name"));
                cities.setCountryCode(rs.getString("CountryCode"));
                cities.setDistrict(rs.getString("District"));
                cities.setPopulation(rs.getInt("Population"));
                pcity_world.add(cities);
            }
            return pcity_world;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Populated Cities in details");
        }
        return null;
    }


    /**
     * Gets all the cities with country continent Top 5.
     * Shine Htet Oo [40478643]
    **/
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
     * Shine Htet Oo [40478643]
    **/
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
     * Gets all the cities with country Name Top 5.
     * Aung Khant Paing [40478639]
    **/
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
    **/
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
     * Gets populated capital cities in a world
     * Bhone Thet Aung [40478627]
     **/
    public ArrayList<Capital_City> getPopulatedCapitalCity() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String query = "SELECT city.Name,country.Name,city.Population FROM city,country WHERE country.Capital = city.ID ORDER BY city.Population desc";

            // Execute SQL statement
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Capital_City> CapitalCities_continent = new ArrayList<Capital_City>();
            while (rs.next()) {
                Capital_City CapCities = new Capital_City();
                CapCities.setcity_Name(rs.getString("city.Name"));
                CapCities.setcountry_Name(rs.getString("country.Name"));
                CapCities.setPopulation(rs.getInt("city.Population"));
                CapitalCities_continent.add(CapCities);
            }
            return CapitalCities_continent;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Populated capital Cities in details");
        }
        return null;
    }


    /**
     * Gets populated capital cities in a continent
     * Bhone Thet Aung [40478627]
     **/
    public ArrayList<Capital_City> getPopulatedCapitalCityContinent() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String query = "SELECT city.Name,country.Name,city.Population FROM city,country WHERE country.Capital = city.ID and country.Continent = 'Asia' ORDER BY city.Population";

            // Execute SQL statement
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Capital_City> CapitalCities_continent = new ArrayList<Capital_City>();
            while (rs.next()) {
                Capital_City CapCities = new Capital_City();
                CapCities.setcity_Name(rs.getString("city.Name"));
                CapCities.setcountry_Name(rs.getString("country.Name"));
                CapCities.setPopulation(rs.getInt("city.Population"));
                CapitalCities_continent.add(CapCities);
            }
            return CapitalCities_continent;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Populated capital Cities in details");
        }
        return null;
    }


    /**
     * Gets populated capital cities in a Region.......
     * Bhone Thet Aung [40478627]
     **/
    public ArrayList<Capital_City> getPopulatedCapitalCityRegion() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String query = "SELECT city.Name,country.Name,city.Population FROM city,country WHERE country.Capital = city.ID and country.Region = 'Southeast Asia' ORDER BY city.Population desc";

            // Execute SQL statement
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Capital_City> CapitalCities_continent = new ArrayList<Capital_City>();
            while (rs.next()) {
                Capital_City CapCities = new Capital_City();
                CapCities.setcity_Name(rs.getString("city.Name"));
                CapCities.setcountry_Name(rs.getString("country.Name"));
                CapCities.setPopulation(rs.getInt("city.Population"));
                CapitalCities_continent.add(CapCities);
            }
            return CapitalCities_continent;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Populated capital Cities in details");
        }
        return null;
    }


    /**
     * Gets top 5 populated capital cities in a world.......
     * Bhone Thet Aung [40478627]
     **/
    public ArrayList<Capital_City> getTop5PopulatedCapitalCityWorld() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String query = "SELECT city.Name,country.Name,city.Population FROM city,country WHERE country.Capital = city.ID ORDER BY city.Population desc limit 5";

            // Execute SQL statement
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Capital_City> CapitalCities_continent = new ArrayList<Capital_City>();
            while (rs.next()) {
                Capital_City CapCities = new Capital_City();
                CapCities.setcity_Name(rs.getString("city.Name"));
                CapCities.setcountry_Name(rs.getString("country.Name"));
                CapCities.setPopulation(rs.getInt("city.Population"));
                CapitalCities_continent.add(CapCities);
            }
            return CapitalCities_continent;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Populated capital Cities in details");
        }
        return null;
    }

    /**
     * Gets top 5 populated capital cities in a continent.......
     * Wint Myat Aung [40478650]
     **/
    public ArrayList<Capital_City> getTop5PopulatedCapitalCityWithContinent() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String query = "SELECT city.Name,country.Name,city.Population FROM city,country WHERE country.Capital = city.ID and country.Continent = 'Europe' ORDER BY city.Population desc limit 5";

            // Execute SQL statement
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Capital_City> CapitalCities_continent = new ArrayList<Capital_City>();
            while (rs.next()) {
                Capital_City CapCities = new Capital_City();
                CapCities.setcity_Name(rs.getString("city.Name"));
                CapCities.setcountry_Name(rs.getString("country.Name"));
                CapCities.setPopulation(rs.getInt("city.Population"));
                CapitalCities_continent.add(CapCities);
            }
            return CapitalCities_continent;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Populated capital Cities in details");
        }
        return null;
    }


    /**
     * Gets top 5 populated capital cities in a region.......
     * Wint Myat Aung [40478650]
    **/
    public ArrayList<Capital_City> getTop5PopulatedCapitalCityWithRegion() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String query = "SELECT city.Name, country.Name, city.Population FROM city,country WHERE country.Capital = city.ID and country.Region = 'Southern Europe'  ORDER BY city.Population desc limit 5";

            // Execute SQL statement
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Capital_City> CapitalCities_region = new ArrayList<Capital_City>();
            while (rs.next()) {
                Capital_City CapCities = new Capital_City();
                CapCities.setcity_Name(rs.getString("city.Name"));
                CapCities.setcountry_Name(rs.getString("country.Name"));
                CapCities.setPopulation(rs.getInt("city.Population"));
                CapitalCities_region.add(CapCities);
            }
            return CapitalCities_region;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Populated capital Cities in details");
        }
        return null;
    }


    /**
     * Gets the population for each Continent.
     * Wint Myat Aung [40478650]
    **/
    public ArrayList<Population> livingCityInContinent() {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String getContinent = "SELECT count(Name), Continent FROM country GROUP BY Continent";
            ResultSet getcont = stmt.executeQuery(getContinent);
            ArrayList<Population> population = new ArrayList<Population>();
            ArrayList<String> getContinentArray = new ArrayList<String>();
            while (getcont.next())
            {
                getContinentArray.add(getcont.getString("Continent"));
            }
            for (String cont : getContinentArray)
            {
                Population pop = new Population();
                ArrayList<String> getCountryArray = new ArrayList<String>();
                BigInteger total = new BigInteger("0");
                BigInteger cityPop = new BigInteger("0");
                pop.setName(cont);
                String getCountry = "SELECT Name FROM country WHERE Continent = '" + cont +"'";
                ResultSet getName = stmt.executeQuery(getCountry);
                while (getName.next())
                {
                    getCountryArray.add(getName.getString("Name"));
                }
                for (String Name : getCountryArray)
                {
                    String strSelect = "SELECT Population, Code FROM country WHERE Name = '" + Name +"'";
                    ResultSet rset = stmt.executeQuery(strSelect);
                    while (rset.next())
                    {
                        int total1 = rset.getInt("Population");
                        BigInteger total2 = BigInteger.valueOf(total1);
                        total = total.add(total2);
                        String code = rset.getString("Code");
                        String getCityPOP = "SELECT sum(Population) as cityPop FROM city WHERE CountryCode = '" + code +"' Group By CountryCode";
                        BigInteger cityPop1 = GetcityPopulation(getCityPOP);
                        cityPop = cityPop.add(cityPop1);
                    }
                }
                pop.setTotal(total);
                pop.setCity(cityPop);
                population.add(pop);
            }
            return population;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get total Population and people who living in the city by Continent.");
            return null;
        }
    }


    /**
     * Gets the population for each Region.
     * Wint Myat Aung [40478650]
    **/
    public ArrayList<Population> livingCityInRegion()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String getRegion = "SELECT count(Name), Region FROM country GROUP BY Region";
            ResultSet getReg = stmt.executeQuery(getRegion);
            ArrayList<Population> population = new ArrayList<Population>();
            ArrayList<String> getRegionArray = new ArrayList<String>();
            while (getReg.next())
            {
                getRegionArray.add(getReg.getString("Region"));
            }
            for (String reg : getRegionArray)
            {
                Population pop = new Population();
                ArrayList<String> getCountryArray = new ArrayList<String>();
                BigInteger total = new BigInteger("0");
                BigInteger cityPop = new BigInteger("0");
                pop.setName(reg);
                String getCountry = "SELECT Name FROM country WHERE Region = '" + reg +"'";
                ResultSet getName = stmt.executeQuery(getCountry);
                while (getName.next())
                {
                    getCountryArray.add(getName.getString("Name"));
                }
                for (String Name : getCountryArray)
                {
                    String strSelect = "SELECT Population, Code, Name FROM country WHERE Name = '" + Name +"'";
                    ResultSet rset = stmt.executeQuery(strSelect);
                    while (rset.next())
                    {
                        int total1 = rset.getInt("Population");
                        BigInteger total2 = BigInteger.valueOf(total1);
                        total = total.add(total2);
                        String code = rset.getString("Code");
                        String getCityPOP = "SELECT sum(Population) as cityPop FROM city WHERE CountryCode = '" + code +"' Group By CountryCode";
                        BigInteger cityPop1 = GetcityPopulation(getCityPOP);
                        cityPop = cityPop.add(cityPop1);
                    }
                }
                pop.setTotal(total);
                pop.setCity(cityPop);
                population.add(pop);
            }
            return population;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get total Population and people who living in the city by Region.");
            return null;
        }
    }


    /**
     * Gets the population for each country.
     * Aung Khant Paing [40478639]
    **/
    public ArrayList<Population> livingCityInCountry()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String getCountryName = "SELECT Name FROM country";
            ResultSet getName = stmt.executeQuery(getCountryName);
            ArrayList<Population> population = new ArrayList<Population>();
            ArrayList<String> getCountryArray = new ArrayList<String>();
            while (getName.next())
            {
                getCountryArray.add(getName.getString("Name"));
            }
            for (String Name : getCountryArray)
            {
                String strSelect = "SELECT Population, Code, Name FROM country WHERE Name = \'" + Name +"\'";
                ResultSet rset = stmt.executeQuery(strSelect);
                while (rset.next())
                {
                    Population pop = new Population();
                    pop.setName(rset.getString("Name"));
                    int total1 = rset.getInt("Population");
                    BigInteger total = BigInteger.valueOf(total1);
                    pop.setTotal(total);
                    String code = rset.getString("Code");
                    String getCityPOP = "SELECT sum(Population) as cityPop FROM city WHERE CountryCode = \'" + code +"\' Group By CountryCode";
                    BigInteger cityPop = GetcityPopulation(getCityPOP);
                    pop.setCity(cityPop);
                    population.add(pop);
                }
            }
            return population;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get total Population and people who living in the city by country name.");
            return null;
        }
    }

    /**
     * Gets the population of people who live in city for each country.
     * Aung Khant Paing [40478639]
     **/
    public BigInteger GetcityPopulation (String query)
    {
        try {
            BigInteger city = new BigInteger("0");
            Statement stmt = con.createStatement();
            ResultSet resultPOP = stmt.executeQuery(query);
            while (resultPOP.next())
            {
                int pop1 = resultPOP.getInt("cityPop");
                BigInteger pop = BigInteger.valueOf(pop1);
                city = city.add(pop);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to total Population of people who living in city or not.");
            return null;
        }
    }


    /**
     * Gets all Population.
     * Aung Khant Paing [40478639]
     **/
    public BigInteger getWorldPopulation()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT Population FROM country";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            BigInteger total = new BigInteger("0");
            while (rset.next())
            {
                int tot = rset.getInt("Population");
                BigInteger tot1 = BigInteger.valueOf(tot);
                total = total.add(tot1);
            }
            BigInteger world = total;
            return world;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world population.");
            return null;
        }
    }


    /**
     * Gets all Asia Continent population.
     * Aung Khant Paing [40478639]
     **/
    public BigInteger getContinentPopulation()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT Population FROM country WHERE Continent = 'Asia'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            BigInteger total = new BigInteger("0");
            while (rset.next())
            {
                int tot = rset.getInt("Population");
                BigInteger tot1 = BigInteger.valueOf(tot);
                total = total.add(tot1);
            }
            BigInteger continent = total;
            return continent;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get continent population.");
            return null;
        }
    }


    /**
     * Gets all Southeast Asia Region population.
     * Aung Khant Paing [40478639]
     **/
    public BigInteger getRegionPopulation()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT Population FROM country WHERE Region = 'Southeast Asia'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            BigInteger total = new BigInteger("0");
            while (rset.next())
            {
                int tot = rset.getInt("Population");
                BigInteger tot1 = BigInteger.valueOf(tot);
                total = total.add(tot1);
            }
            BigInteger region = total;
            return region;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get region population.");
            return null;
        }
    }


    /**
     * Gets all Egypt Country population.
     * Shine Htet Oo [40478643]
     **/
    public BigInteger getCountryPopulation()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT Population FROM country WHERE Name = 'Egypt'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            BigInteger total = new BigInteger("0");
            while (rset.next())
            {
                int tot = rset.getInt("Population");
                BigInteger tot1 = BigInteger.valueOf(tot);
                total = total.add(tot1);
            }
            BigInteger country = total;
            return country;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country population.");
            return null;
        }
    }


    /**
     * Gets all Rio Grande do Sul district population.
     * Shine Htet Oo [40478643]
     **/
    public BigInteger getDistrictPopulation()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT Population FROM city WHERE District = 'Rio Grande do Sul'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            BigInteger total = new BigInteger("0");
            while (rset.next())
            {
                int tot = rset.getInt("Population");
                BigInteger tot1 = BigInteger.valueOf(tot);
                total = total.add(tot1);
            }
            BigInteger district = total;
            return district;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get District population.");
            return null;
        }
    }


    /**
     * Gets all Los Angeles city population.
     * Shine Htet Oo [40478643]
     **/
    public BigInteger getCityPopulation()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT Population FROM city WHERE Name = 'Los Angeles'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            BigInteger total = new BigInteger("0");
            while (rset.next())
            {
                int tot = rset.getInt("Population");
                BigInteger tot1 = BigInteger.valueOf(tot);
                total = total.add(tot1);
            }
            BigInteger city = total;
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City population.");
            return null;
        }
    }


    /**
     * Get the greatest number to smallest language percentage of the world population
     * Shine Htet Oo [40478643]
     */
    public ArrayList<Language> getLanguagePercentage()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            ArrayList<Language> language = new ArrayList<Language>();
            String[] languagename = {"Chinese", "English", "Hindi", "Spanish", "Arabic"};

            for (String langname : languagename)
            {
                BigDecimal population = new BigDecimal("0");
                BigDecimal perc = new BigDecimal("100");
                Language language1 = new Language();
                ArrayList<Language> percentageArray = new ArrayList<Language>();

                String getPercentage = "SELECT Percentage, CountryCode FROM countrylanguage WHERE Language = '" + langname +"'";

                // Get the Percentage
                ResultSet getPer = stmt.executeQuery(getPercentage);
                while (getPer.next())
                {
                    Language languagePercentage = new Language();
                    languagePercentage.setcountryName(getPer.getString("CountryCode"));
                    languagePercentage.setPercentage(getPer.getBigDecimal("Percentage"));
                    percentageArray.add(languagePercentage);
                }

                // get the total population for each language
                for (Language perArray : percentageArray)
                {
                    BigDecimal percentage = perArray.getPercentage();
                    String getPopulation = "SELECT Population FROM country WHERE Code = '" + perArray.getcountryName() +"'";

                    ResultSet getPop = stmt.executeQuery(getPopulation);
                    while (getPop.next())
                    {
                        BigDecimal pop = getPop.getBigDecimal("Population");
                        BigDecimal pop2 = percentage.multiply(pop).divide( perc, 0);
                        population = population.add(pop2);
                    }
                }

                language1.setlanguageName(langname);
                language1.setpopulation(population);
                language.add(language1);
            }
            return language;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get greatest number to smallest language percentage of the world population.");
            return null;
        }
    }


    /**
     * Print a list of countries.
     * Aung Khant Paing [40478639]
    **/
    public void PrintCountryList(ArrayList<Country> country)
    {
        // Check the Country data exit or not.
        if (country == null)
        {
            System.out.println("Not getting the country data");
            return;
        }
        // Check the City Data is empty or not.
        if (country.size() == 0)
        {
            System.out.println("Country data is empty.");
            return;
        }
        // Print header
        System.out.println(String.format("%-5s %-50s %-15s %-30s %-25s %-20s","Code", "Name", "Continent", "Region", "Population", "Capital"));
        System.out.println(String.format("%-5s %-50s %-15s %-30s %-25s %-20s","----", "----", "---------", "------", "----------", "-------"));
        // Loop over all Country in the list
        for (com.napier.sem.Country cou : country)
        {
            // Check the contains exit or not.
            if (cou == null) {
                System.out.println("Not Getting the Full information of country.");
                continue;
            }
            String code = cou.getcode();
            String name = cou.getname();
            String Con = cou.getCon();
            String Reg = cou.getReg();
            int Pop = cou.getPop();
            String cap = cou.getcap();
            String countrystring = String.format("%-5s %-50s %-15s %-30s %-25s %-20s", code, name, Con, Reg, Pop, cap);
            System.out.println(countrystring);
        }
        for (int j = 1; j <= 50; j+=1)
        {
            System.out.print("xx");
        }
        System.out.println("\n");
    }


    /**
     * Prints a list of cities
     * Shine Htet Oo [40478643]
    **/
    public void outputCity(ArrayList<City> city) {
        // Check the City data exit or not.
        if (city == null)
        {
            System.out.println("Not getting the city data.");
            return;
        }
        // Check the City Data is empty or not.
        if (city.size() == 0)
        {
            System.out.println("City data is empty.");
            return;
        }
        // Print header
        System.out.println(String.format("%-40s %-20s %-40s %-30s", "Name", "CountryCode", "District", "Population"));
        System.out.println(String.format("%-40s %-20s %-40s %-30s", "----", "-----------", "--------", "----------"));
        // Loop over all City in the list
        for (City ct : city) {
            // Check the contains exit or not.
            if (ct == null) {
                System.out.println("Not Getting the Full information of city.");
                continue;
            }
            String Name = ct.getName();
            String CountryCode = ct.getCountryCode();
            String District = ct.getDistrict();
            int Population = ct.getPopulation();
            String ct_string = String.format("%-40s %-20s %-40s %-30s", Name, CountryCode, District, Population);
            System.out.println(ct_string);
        }
        for (int i = 1; i <= 50; i = i +1)
        {
            System.out.print("xx");
        }
        System.out.println("\n");
    }


    /**
     * Prints a list of Capital cities
     * Wint Myat Aung [40478650]
    **/
    public void outputCapitalCity(ArrayList<Capital_City> CapCities) {
        // Check the Capital City data exit or not.
        if (CapCities == null)
        {
            System.out.println("Not getting the Capital city data.");
            return;
        }
        // Check the Capital City Data is empty or not.
        if (CapCities.size() == 0)
        {
            System.out.println("Capital City data is empty.");
            return;
        }
        // Print header
        System.out.println(String.format("%-40s %-40s %-20s", "Capital City", "Country", "Population"));
        System.out.println(String.format("%-40s %-40s %-20s", "------------", "-------", "----------"));
        // Loop over all Capital City in the list
        for (Capital_City capCt : CapCities) {
            // Check the contains exit or not.
            if (capCt == null) {
                System.out.println("Not Getting the Full information of Capital city.");
                continue;
            }
            String city_Name = capCt.getcity_Name();
            String country_Name = capCt.getcountry_Name();
            int Population = capCt.getPopulation();
            String capCt_string = String.format("%-40s %-40s %-20s", city_Name, country_Name, Population);
            System.out.println(capCt_string);
        }
        for (int i = 1; i <= 50; i = i +1)
        {
            System.out.print("xx");
        }
        System.out.println("\n");
    }

    /**
     * Prints the population output
     * Aung Khant Paing [40478643]
     **/
    public void printPopulation(ArrayList<Population> popopulation) {
        try {
            // Check the Country data exit or not.
            if (popopulation == null)
            {
                System.out.println("Not getting the Population data");
                return;
            }
            // Check the value is not null
            if (popopulation.size() == 0)
            {
                System.out.println("Empty Population ArrayList.");
            }
            else
            {
                System.out.println(String.format("%-50s %-30s %-40s %-40s", "Name", "Total Population", "People Who living in City", "People Who not living in City"));
                System.out.println(String.format("%-50s %-30s %-40s %-40s", "----", "----------------", "-------------------------", "-----------------------------"));
                for (Population pop : popopulation) {
                    // Check the contains exit or not.
                    if (pop == null) {
                        System.out.println("Not Getting the Full information of Population.");
                        continue;
                    }
                    String name = pop.getName();
                    BigInteger total = pop.getTotal();
                    BigInteger city = pop.getCity();
                    BigInteger nocity = total.subtract(city);

                    // Check the total population is equal to zero or not.
                    if ( total.compareTo(BigInteger.ZERO) == 0){
                        System.out.println(String.format("%-50s %-30s %-40s %-40s", name, total, city+"("+city+"% )", nocity+"("+nocity+"% )"));
                    }

                    else
                    {
                        // calculate the percentage of people who live in city population.
                        BigDecimal perc = new BigDecimal("100");
                        BigDecimal citypercentage = new BigDecimal (city).multiply(perc).divide( new BigDecimal (total), 2);

                        // Calculate the percentage of people who do not live in city population.
                        BigDecimal nocitypercentage = perc.subtract(citypercentage);
                        System.out.println(String.format("%-50s %-30s %-40s %-40s", name, total, city+"("+citypercentage+"% )", nocity+"("+nocitypercentage+"% )"));
                    }
                }
                for (int i = 1; i <= 50; i = i +1)
                {
                    System.out.print("xx");
                }
                System.out.println("\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to output the living city population");
        }
    }


    /**
     * Print the greatest number to smallest language percentage of the world population
     */
    public void outputLanguage(ArrayList<Language> language)
    {
        // Check the Capital City data exit or not.
        if (language == null)
        {
            System.out.println("Not getting the language data.");
            return;
        }
        // Check the Capital City Data is empty or not.
        if (language.size() == 0)
        {
            System.out.println("Language data is empty.");
            return;
        }
        Collections.sort(language, Language.compareLanguage);
        // Loop over all Language in the list
        for (Language lang : language) {
            // Check the contains exit or not.
            if (lang == null) {
                System.out.println("Not Getting the Full information of language data.");
                continue;
            }
            String name = lang.getlanguageName();
            BigDecimal population = lang.getpopulation();
            BigInteger totalPopulation = getWorldPopulation();
            //Calculate the percentage of the population.
            BigDecimal populationPercentage = population.multiply(new BigDecimal("100")).divide( new BigDecimal (totalPopulation), 2);
            System.out.println(name+" language is used " + population + "(" + populationPercentage +"%) of the world population.");
        }
        for (int i = 1; i <= 50; i = i +1)
        {
            System.out.print("xx");
        }
        System.out.println("\n");
    }
}

