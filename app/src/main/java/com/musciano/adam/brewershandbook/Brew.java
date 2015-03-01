package com.musciano.adam.brewershandbook;

import java.util.Date;

/**
 * Created by adam on 3/1/2015.
 */
public class Brew {
    private String name,type,dateStarted,dateFinished;
    private double volume;
    private double og,fg;
    public Brew(String name){
        this.name= name;
    }
    public String getName(){
        return name;
    }

    public String toString(){
        return ""+name+";"+type+";"+og+";"+fg+";"+dateStarted+";"+dateFinished+";"+volume;
    }
}
