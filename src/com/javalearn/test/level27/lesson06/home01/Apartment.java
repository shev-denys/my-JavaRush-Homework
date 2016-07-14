package com.javalearn.test.level27.lesson06.home01;

public class Apartment {
    private String location;
    private final RealEstate realEstate;

    public Apartment(RealEstate realEstate) {
        this.realEstate = realEstate;
        setLocation(String.valueOf(Math.random() * 10));
    }

    public  String getLocation() {
        synchronized(location){
        return location;}
    }

    public  void setLocation(String location) {
        synchronized(location){
        this.location = location;}
    }

    public void revalidate(boolean isEmpty) {
        if (isEmpty)
            realEstate.up(this);
    }
}
