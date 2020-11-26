package com.napier.sem;

import java.math.BigDecimal;

public class Population {

    private String name;
    public String getName(){
        return name;
    }
    public void setName(String attribute){
        this.name = attribute;
    }

    private BigDecimal total;
    public BigDecimal getTotal(){
        return total;
    }
    public void setTotal(BigDecimal attribute){
        this.total = attribute;
    }

    private BigDecimal city;
    public BigDecimal getCity(){
        return city;
    }
    public void setCity(BigDecimal attribute){
        this.city = attribute;
    }
}
