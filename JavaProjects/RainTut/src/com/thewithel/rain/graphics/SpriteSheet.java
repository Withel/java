package com.thewithel.rain.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

//Sprite its a class that is loading the SpriteSheet.png where we store our Sprites, these are single squares of our map
//it works kinda the same as in minecraft

public class SpriteSheet {

    private String path;
    public final int SIZE;
    public int[] pixels;

    //when youre starting writing a path its really important to start with '/' sign
    public static SpriteSheet tiles = new SpriteSheet("/textures/spritesheet.png", 256);

    public SpriteSheet(String path, int size){
        this.path = path;
        this.SIZE = size;
        pixels = new int[SIZE*SIZE];
        load();
    }

    private void load() {
        try {
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));            //we dont want to deal with buffered image, we want to have pixels
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0, 0, w, h,pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
