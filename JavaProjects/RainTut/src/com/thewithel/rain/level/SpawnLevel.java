package com.thewithel.rain.level;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpawnLevel extends Level{


    public SpawnLevel(String path) {
        super(path);
    }

    //one pixel in image equals one tile in tha game
    protected void loadLevel(String path){
        try{
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            int w = width = image.getWidth();
            int h = height = image.getHeight();
//            tiles = new Tile[w*h];
            tiles = new int[w*h];
            image.getRGB(0, 0, w, h, tiles, 0, w);
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Exeption! Could not load Level file");
        }
    }

    @Override
    protected void generateLevel() {
    }

    //This function reads from file a level, and change pixel array into tiles array
    // Grass = 0xFF00
    // Flower = FFFF00
    // Rock = 0x7F7F00
    //ff before every color handles 'alpha channel'
//    @Override
//    protected void generateLevel(){
//
//        for (int i =0; i<tiles.length; i++){
//            if(tiles[i] == 0xff00ff00){
//                tiles[i] = Tile.grass;
//            }
//            if(tiles[i] == 0xffffff00){
//                tiles[i] = Tile.flower;
//            }
//            if(tiles[i] == 0xff7f7f7F){
//                tiles[i] = Tile.rock;
//            }
//        }
//
//
//    }



}
