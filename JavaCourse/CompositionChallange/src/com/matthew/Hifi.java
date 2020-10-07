package com.matthew;

public class Hifi {

    private String name;
    private Speakers theSpeakers;
    private String head;

    public Hifi(String name, Speakers theSpeakers, String head) {
        this.name = name;
        this.theSpeakers = theSpeakers;
        this.head = head;
    }

    public void playMusic(int songNumber, boolean status){
        theSpeakers.turnOn(status);
        if(status == false){
            System.out.println("Speakers are turned off, you can't play music");
            return;
        }
        System.out.println("Playing song number: "+songNumber);
    }

    public String getName() {
        return name;
    }

    public Speakers getTheSpeakers() {
        return theSpeakers;
    }

    public String getHead() {
        return head;
    }
}
