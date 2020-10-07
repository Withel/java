package com.thewithel.rain.level;

import com.thewithel.rain.graphics.Screen;
import com.thewithel.rain.level.tile.Tile;

public class Level {
    //basically what level does is it compiles and holds the list of tiles and manage it
    //when were moving on the map it is updating that list
    //it organises and manages which tiles actually needs to be rendered

//    protected Tile[] tiles;
    protected int width, height;
    protected int[] tilesInt;          //each integer is ID of an tile, e.g. 0 might be grass 1 rocks etc
    protected int[] tiles;              //this is going to containg all the level tiles, colors from file

    public Level(int width, int height){
        this.width = width;
        this.height = height;
        tilesInt = new int[width*height];
 //       tiles = new Tile [16*16];
        generateLevel();
    }

    public Level(String path){
        loadLevel(path);
        generateLevel();
    }

    protected void generateLevel() {

    }

    protected void loadLevel(String path){

    }

    public void update(){

    }

    private void time(){

    }

    //SETTINGS CORNERS WILL GUARANTEE US TO RENDER ONLY TILES THAT WERE SEEING ON THE SCREEN
    public void render(int xScroll, int yScroll, Screen screen){
        //xScroll nad yScroll is the location of the player
        screen.setOffset(xScroll, yScroll);
        //variables responsible for setting corners (tiles not pixels)
        //xScroll is the left most
        //its converted into a Tile precision by dividing (moving bits) by 16 (or with bits by 4)
        int x0 = xScroll >> 4;
        //adding 16 will make us to render one additional row or column of tiles from right and bottom
        int x1 = (xScroll + screen.width + 16) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + screen.height + 16) >> 4;

        //when we render it needs to go back to pixel precision
        for(int y = y0; y<y1; y++){
            for(int x=x0; x<x1; x++){
                getTile(x, y).render(x, y, screen);

                //bad way of making tiles
//                if((x+y*16 < 0) || (x+y*16 >= 256)) {
//                    Tile.voidTile.render(x, y, screen);
//                    continue;
//                }
//                tiles[x+y*16].render(x, y, screen);
            }
        }
    }

    //method which will allow us to retrieve Tile
    // Grass = 0xFF00
    // Flower = FFFF00
    // Rock = 0x7F7F7F
    // Black = 000000
    // Red = FF0000
    public Tile getTile(int x, int y){
        if(x < 0 || y <0 || x >= width || y>=height) {
            System.out.println("not good");
            return Tile.voidTile;
        }
        System.out.println("good");
        if(tiles[x+y*width] == 0xFF00FF00) return Tile.grass;
        if(tiles[x+y*width] == 0xFFFFFF00) return Tile.flower;
        if(tiles[x+y*width] == 0xFF7F7F7F) return Tile.rock;
        if(tiles[x+y*width] == 0xFFFF0000) return Tile.red;
        if(tiles[x+y*width] == 0xFF000000) return Tile.black;
        return Tile.voidTile;
    }
}
