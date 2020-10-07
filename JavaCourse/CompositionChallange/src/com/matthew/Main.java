package com.matthew;

public class Main {

    public static void main(String[] args) {

        Dimensions theDimensions = new Dimensions(20,20,10);
        Speakers theSpeakers = new Speakers("Yamaha", 2);
        Hifi theHifi = new Hifi("Yamaha", theSpeakers, "MusicCast");
        Shelf theShelf = new Shelf(150, theDimensions);

        Pillow thePillow = new Pillow("silk", 100, 70);
        Quilt theQuilt = new Quilt("silk", 200,120);
        Bed theBed = new Bed("Kappa", "Kappowinik", thePillow, theQuilt);

        Room theRoom = new Room(theBed, theHifi, theShelf);

        theRoom.goToSleep();
        theRoom.getTheHifi().playMusic(13, true);
        theRoom.takingOff();
        theRoom.getTheHifi().playMusic(13, false);
    }
}
