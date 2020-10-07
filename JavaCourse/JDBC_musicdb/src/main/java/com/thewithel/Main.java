package com.thewithel;

import com.thewithel.Model.Artist;
import com.thewithel.Model.DataSource;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();

        if (!dataSource.open()) {
            System.out.println("Can't open datasource");
        }

        List<Artist> artists = dataSource.queryArtists(DataSource.ORDER_BY_ASC);

        if (artists == null) {
            System.out.println("No artists");
        } else {
            for (Artist artist : artists) {
                System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
            }
        }

        List<String> albumsForArtist =
                dataSource.queryAlbumsForArtist("Iron Maiden", DataSource.ORDER_BY_DES);

        for(String album : albumsForArtist){
            System.out.println(album);
        }

        dataSource.close();
    }
}
