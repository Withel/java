package com.thewithel.rain.graphics;

import com.thewithel.rain.entity.mob.Player;
import com.thewithel.rain.level.tile.Tile;

import java.util.Random;

public class Screen {

    public int width, height;
    public int[] pixels;                                            //FOR NOW PUBLIC ALE BEDZIEMY KMINIC
    public final int MAP_SIZE = 64;                                  //this is for setting up tiles
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;
    public int[] tiles = new int [MAP_SIZE*MAP_SIZE];
    public int xOffset, yOffset;
    private Random random = new Random();


    //it makes screen
    public Screen(int width, int height){
        this.width = width;
        this.height = height;
        pixels = new int[width * height];       // its 50 400 elements

        for (int i =0;i<MAP_SIZE*MAP_SIZE; i++){
            tiles[i] = random.nextInt(0xffffff);
        }
    }

    //method that makes every pixel in our
    public void clear(){
        for(int i=0;i<pixels.length; i++){
            pixels[i] = 0;
        }
    }




    //xa and ya are absolute values which means the position + offset value
    public void renderTile(int xp, int yp, Tile tile){
        //two lines below calculate the player movement
        xp -= xOffset;
        yp -= yOffset;
        for(int y=0; y<tile.sprite.SIZE; y++){
            int ya = y + yp;
            for(int x=0; x<tile.sprite.SIZE; x++){
                int xa = x + xp;
                //this line below makes sure that were rendering on screen only what we see
                if(xa < -tile.sprite.SIZE || xa>= width || ya <0 || ya >= height) break;
                //we can make this to negative values, but for some reason cant expand to positive
                if(xa < 0 ) xa = 0;
                //first part deals which where the sprite is rendered, which pixels on the screen are rendered
                //second one deals with which pixels of the sprite are rendered
                pixels[xa + ya*width] = tile.sprite.pixels[x+y*tile.sprite.SIZE];
            }
        }
    }

    //variables ys and xs are for flipping player, but I like to have it in textures
    //you can acheieve that by reversing for loop (xs = 31 - x) and adding new variable to method arguments
    //flip = <direction>
    public void renderPlayer(int xp, int yp, Sprite sprite){
        xp -= xOffset;
        yp -= yOffset;
        int color;
        //int ys = 31 - y;
        for(int y=0; y<32; y++){
            int ya = y + yp;
            for(int x=0; x<32; x++){
                int xa = x + xp;
                //int xs = 31- x
                if(xa < -32 || xa>= width || ya <0 || ya >= height) break;
                if(xa < 0 ) xa = 0;
                color = sprite.pixels[x+y*32];
                if(color != 0xff78C380) {
                    pixels[xa + ya * width] = color;
                }
            }
        }
    }

    public void setOffset(int xOffset, int yOffset){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

}

























//this method rendes a map by generating every single pixel one by one that is stored in int array
//xp and yp are position on map, and Offsets are +/- coordinates for moving
//    public void render(int xOffSet, int yOffSet){
//        int yp, xp;
//        for(int y=0; y<height; y++){
//            yp = y +yOffSet;
//            if(yp<0 || yp>=height) continue;
//            for(int x=0; x<width; x++){
//                xp = x +xOffSet;
//                if(xp<0 || xp>=width) continue;
//                pixels[xp + yp*width] = Sprite.grass.pixels[(x&15)+(y&15)*Sprite.grass.SIZE];
//            }
//        }
//    }

