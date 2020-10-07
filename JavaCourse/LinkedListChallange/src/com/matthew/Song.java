package com.matthew;

public class Song {
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }


    //metoda pozwalająca zwrócić jakby wszystkie pola w formie Stringa
    @Override
    public String toString() {
        return this.title + ": " +this.duration;
    }
}
