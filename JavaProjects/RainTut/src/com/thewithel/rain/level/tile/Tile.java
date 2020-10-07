package com.thewithel.rain.level.tile;

import com.thewithel.rain.graphics.Screen;
import com.thewithel.rain.graphics.Sprite;

public class Tile {
    //each tile needs to have position, sprite. Tile its something that we need to
    //display all time

    public int x, y;
    public Sprite sprite;

    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile voidTile = new VoidTile(Sprite.voidSprite);
    public static Tile flower = new FlowerTile(Sprite.flower);
    public static Tile rock = new RockTile(Sprite.rock);
    public static Tile rockTile = new RockTile2(Sprite.rockTile);

    public static Tile red = new RedTile(Sprite.red);
    public static Tile black = new BlackTile(Sprite.black);

    //everytime when were creating tile we need to pass to it sprite
    public Tile(Sprite  sprite){
        this.sprite = sprite;
    }

    //every tile render itself
    public void render(int x, int y, Screen screen){

    }

    //if we won't override this by default it will return false
    //method that checks if we can pass through specific tile
    public boolean solid(){
        return false;
    }
}
