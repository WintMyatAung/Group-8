package com.napier.sem;

import java.math.BigDecimal;
import java.util.Comparator;

public class Language {
    private String languageName;
    public String getlanguageName(){
        return languageName;
    }
    public void setlanguageName(String attribute){
        this.languageName = attribute;
    }

    private BigDecimal population;
    public BigDecimal getpopulation(){
        return population;
    }
    public void setpopulation(BigDecimal attribute){
        this.population = attribute;
    }

    public static Comparator<Language> compareLanguage = new Comparator<Language>() {
        public int compare(Language lang1, Language lang2)
        {
            BigDecimal pop1 = lang1.getpopulation();
            BigDecimal pop2 = lang2.getpopulation();
            int result = pop2.compareTo(pop1);
            return result;
        }
    };

    private String countryName;
    public String getcountryName(){
        return countryName;
    }
    public void setcountryName(String attribute){
        this.countryName = attribute;
    }

    private BigDecimal percentage;
    public BigDecimal getPercentage(){
        return percentage;
    }
    public void setPercentage(BigDecimal attribute){
        this.percentage = attribute;
    }
}
