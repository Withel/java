package com.thewithel.rain.level.tile;

import com.thewithel.rain.graphics.Screen;
import com.thewithel.rain.graphics.Sprite;

public class GrassTile extends Tile {

    public GrassTile(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void render(int x, int y, Screen screen) {
        //we need to conver x and y back to pixel precision before we render it
        screen.renderTile(x << 4, y << 4, this);
    }
}
