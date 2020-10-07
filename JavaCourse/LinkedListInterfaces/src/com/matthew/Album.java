package com.matthew;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration){
        return this.songs.add(new Song(title, duration));
    }

//    private Song findSong(String title){
//        //inna forma użycia for
//        //tworzy zmienna checkedSong i ogólnie leci przez całą listę
//        for (Song checkedSong: this.songs) {
//            if(checkedSong.getTitle().equals(title)){
//                return checkedSong;
//            }
//        }
//        return null;
//    }

//    private Song findSongV2(String title){
//
//        for(int i=0; i<songs.size();i++){
//            if (songs.get(i).getTitle().equals(title))
//                return songs.get(i);
//        }
//        return null;
//    }

    public boolean addToPlayList(int trackNumber, List<Song> playList){
        Song checkedSong = this.songs.findSong(trackNumber);
        if(checkedSong != null){
            playList.add(checkedSong);
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaLists(String title, List<Song> playlist){
        Song checkedSong = songs.findSong(title);
        if (checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    private class SongList{
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<Song>();
        }

        public boolean add(Song song){
            if(songs.contains(song)){
                return false;
            }
            this.songs.add(song);
            return true;
        }

        private Song findSong(String title){
            for (Song checkedSong: this.songs) {
                if(checkedSong.getTitle().equals(title)){
                    return checkedSong;
                }
            }
            return null;
        }

        public Song findSong(int trackNumber){
            int index = trackNumber -1;
            if ((index >=0) &&(index<songs.size())){
                return songs.get(index);
            }
            return null;
        }
    }



}
