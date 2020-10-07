package com.thewithel.rain.level;

import java.util.Random;

public class RandomLevel extends Level {

    private static final Random random = new Random();

    public RandomLevel(int width, int height) {
        super(width, height);  //whatever we put in super it will go to the constructor in class were extending from
    }

    @Override
    protected void generateLevel() {
        for(int y=0; y<height;y++){
            for(int x=0;x<width;x++){
                tilesInt[x+y*width] = random.nextInt(4);       //parameter in nextInt method is range of numbers eg 4 = {0,1,2,3}
            }
        }
    }
}
