package com.matthew;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static LinkedList<Album> albumList = new LinkedList<Album>();

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean quit = false;
        int option;

        printMenu();
        while(!quit){
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 0:
                    printMenu();
                    break;
                case 1:
                    addAlbum();
                    break;
                case 2:
                    //remove
                    break;
                case 3:
                    //edit
                    break;
                case 4:
                    addSongMain();
                    break;
                case 5:
                    //edit/remove song
                    break;
                case 6:
                    printAlbums(albumList);
                    break;
                case 7:
                    //something pewnie sort
                    break;
                case 8:
                    quit = true;
                    break;
            }
        }
    }

    public static void printMenu(){
        System.out.println("Chose your option: (Press 0 to show main menu)");
        System.out.println("\n1 - Add a CD to your list" +
                            "\n2 - Remove CD from your list"+
                            "\n3 - Edit CD from your list"+
                            "\n4 - Add song to your CD"+
                            "\n5 - Edit or remove songs from your CD" +
                            "\n6 - Show list of your CD's"+
                            "\n8 - Exit.");
    }

    public static void addAlbum(){
        String name, artist;
        int year;
        System.out.println("Enter the name of the album:");
        name = scanner.nextLine();
        System.out.println("Enter the name of the artist");
        artist = scanner.nextLine();
        System.out.println("Enter the year when album was released");
        year = scanner.nextInt();
        albumList.add(new Album(name, artist, year));
        System.out.println("Album added succesfully");
    }

    public static void addSongMain(){
        String nameFind;
        System.out.println("To which album you want to add song (enter the name");
        nameFind = scanner.nextLine();
        Album toChange;
        toChange = findAlbum(nameFind);
        if(toChange == null){
            System.out.println("Cannot find album at name: " +nameFind);
            return;
        }
        String name;
        double duration;
        System.out.println("Enter the name of the song");
        name = scanner.nextLine();
        System.out.println("Enter duration of the song");
        duration = scanner.nextDouble();
        if(toChange.addSong(name, duration)){
            System.out.println("Succesfully added song");
        }else{
            System.out.println("Song already exist or something went wrong KappaHD");
        }
    }

    public static void printAlbums(LinkedList<Album> albumList){
        ListIterator<Album> albumListIterator = albumList.listIterator();
        int i = 0;
        while(albumListIterator.hasNext()){
            System.out.print("Album " + i+1 +". ");
            System.out.println(albumListIterator.next().toString());
            System.out.println("Songs on that album are: ");
            albumList.get(i).printSongs(albumList.get(i).getSongList());
            System.out.println("==================");
            i++;
        }
    }

    public static Album findAlbum(String name){
            Album checked;
            for (int i=0;i<albumList.size();i++){
                checked = albumList.get(i);
                if (checked.getTitle().equals(name)) return checked;
        }
        return null;
    }
}
