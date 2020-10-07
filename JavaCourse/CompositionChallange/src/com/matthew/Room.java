package com.matthew;

public class Room {

    private Bed theBed;
    private Hifi theHifi;
    private Shelf theShelf;

    public Room(Bed theBed, Hifi theHifi, Shelf theShelf) {
        this.theBed = theBed;
        this.theHifi = theHifi;
        this.theShelf = theShelf;
    }

    public void takingOff(){
        getTheShelf().takeOffCd(10);
    }

    public void goToSleep(){
        theBed.makeThebed();
        System.out.println("I've made my bed, now I'm going to sleep.");
    }

    private Bed getTheBed() {
        return theBed;
    }

    public Hifi getTheHifi() {
        return theHifi;
    }

    private Shelf getTheShelf() {
        return theShelf;
    }
}
