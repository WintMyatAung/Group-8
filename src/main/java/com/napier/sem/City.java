package com.napier.sem;

public class City {

    private int ID;
    public int getID(){
        return ID;
    }
    public void setID(int attribute){
        this.ID = attribute;
    }

    private String Name;
    public String getName(){
        return Name;
    }
    public void setName(String attribute){
        this.Name = attribute;
    }

    private String CountryCode;
    public String getCountryCode(){
        return CountryCode;
    }
    public void setCountryCode(String attribute){
        this.CountryCode = attribute;
    }

    public String District;
    public String getDistrict(){
        return District;
    }
    public void setDistrict(String attribute){
        this.District = attribute;
    }

    public int Population;
    public int getPopulation(){
        return Population;
    }
    public void setPopulation(int attribute){
        this.Population = attribute;
    }
}
