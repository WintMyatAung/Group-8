package com.napier.sem;

import java.math.BigInteger;

public class Population {

    private String name;
    public String getName(){
        return name;
    }
    public void setName(String attribute){
        this.name = attribute;
    }

    private BigInteger total;
    public BigInteger getTotal(){
        return total;
    }
    public void setTotal(BigInteger attribute){
        this.total = attribute;
    }

    public BigInteger city;
    public BigInteger getCity(){
        return city;
    }
    public void setCity(BigInteger attribute){
        this.city = attribute;
    }

}
