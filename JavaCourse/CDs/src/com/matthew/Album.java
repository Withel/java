package com.matthew;

import java.util.ArrayList;

public class Album {
    private String title;
    private String artist;
    private int year;
    private ArrayList<Song> songList;

    public Album(String title, String artist, int year) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        songList = new ArrayList<Song>();
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }

    public String getTitle() {
        return title;
    }

    public boolean addSong(String name, double duration){
        if (findSong(name) == null) {
            songList.add(new Song(name, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String name){
        for (int i=0; i<songList.size(); i++){
            if (songList.get(i).getName().equals(name))
                return songList.get(i);
        }
        return null;
    }

    public void printSongs(ArrayList<Song> songList){
        if (songList.size() == 0){
            System.out.println("There are no songs on the cd");
            return;
        }
        for (int i=0; i<songList.size(); i++)
            System.out.println(songList.get(i).toString());
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", year=" + year +
                '}';
    }


}
