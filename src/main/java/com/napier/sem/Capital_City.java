package com.napier.sem;

public class Capital_City {
    private String city_Name;
    public String getcity_Name(){
        return city_Name;
    }
    public void setcity_Name(String attribute){
        this.city_Name = attribute;
    }


    private String country_Name;
    public String getcountry_Name(){
        return country_Name;
    }
    public void setcountry_Name(String attribute){
        this.country_Name = attribute;
    }


    public int Population;
    public int getPopulation(){
        return Population;
    }
    public void setPopulation(int attribute){
        this.Population = attribute;
    }
}
