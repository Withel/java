package com.matthew;

public class Bed {

    private String name;
    private String manufacturer;
    private Pillow thePillow;
    private Quilt theQuilt;

    public Bed(String name, String manufacturer, Pillow thePillow, Quilt theQuild) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.thePillow = thePillow;
        this.theQuilt = theQuild;
    }

    public void makeThebed(){
        thePillow.turnOver();
        theQuilt.place();
    }
}
