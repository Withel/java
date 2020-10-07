package com.matthew;

public class Speakers {

    private String manufacturer;
    private int speakersCount;
    private boolean turned;

    public Speakers(String manufacturer, int speakersCount) {
        this.manufacturer = manufacturer;
        this.speakersCount = speakersCount;
    }

    public void turnOn(boolean status){
        this.turned = status;
        System.out.println("Speakers are turned on =" +status);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getSpeakersCount() {
        return speakersCount;
    }
}
