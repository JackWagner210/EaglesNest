package com.wack.eaglesnest.level.tile;

import com.wack.eaglesnest.graphics.Screen;
import com.wack.eaglesnest.graphics.Sprite;

public class VoidTile extends Tile {

    public VoidTile(Sprite sprite){
        super(sprite);
    }
    public void render(int x, int y, Screen screen){
        screen.renderTile(x << 4, y << 4, this);
    }

}
