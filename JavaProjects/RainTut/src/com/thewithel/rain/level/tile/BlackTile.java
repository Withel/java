package com.thewithel.rain.level.tile;

import com.thewithel.rain.graphics.Screen;
import com.thewithel.rain.graphics.Sprite;

public class BlackTile extends Tile{
    public BlackTile(Sprite sprite) {
        super(sprite);
    }

    public void render(int x, int y, Screen screen){
        screen.renderTile(x<<4, y<<4, this);
    }
}
