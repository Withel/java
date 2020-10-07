package com.thewithel.rain.level;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DickLevel extends Level {

    public DickLevel(String path) {
        super(path);
    }

    protected void loadLevel(String path){
        try{
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            int w = width = image.getWidth();
            int h = height = image.getHeight();
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
}
