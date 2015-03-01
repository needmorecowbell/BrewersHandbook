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
    public Brew(String name, String type,String og,String fg, String dateStarted, String dateFinished, String volume){
        this.name=name;
        this.type=type;
        this.og=Double.parseDouble(og);
        this.fg=Double.parseDouble(fg);
        this.dateStarted=dateStarted;
        this.dateFinished=dateFinished;
        this.volume=Double.parseDouble(volume);
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public String getDateStarted(){
        return dateStarted;
    }
    public String getDateFinished(){
        return dateFinished;
    }
    public double getVolume(){
        return volume;
    }
    public double getOg(){
        return og;
    }
    public double getFg(){
        return fg;
    }

    public String toString(){
        return ""+name+";"+type+";"+og+";"+fg+";"+dateStarted+";"+dateFinished+";"+volume;
    }
}
