package com.wack.eaglesnest.graphics;

import com.wack.eaglesnest.level.tile.Tile;

import java.util.Random;

public class Screen {

    private final int MAP_SIZE = 64;
    private final int MAP_SIZE_MASK = MAP_SIZE - 1;
    public int width, height;
    public int[] pixels;
    public int xOffset, yOffset;
    public int[] tiles = new int[MAP_SIZE << 6]; //4096 or 64 * 64. bitshift left 2^6

    private Random random = new Random();

    public Screen(int width, int height){
        this.width = width;
        this.height = height;
        pixels = new int[width * height]; //50,400 || 0-50399

        for(int i = 0; i < MAP_SIZE << 6; i++){
            tiles[i] = random.nextInt(0xffffff);
            tiles[0] = 0;
        }

    }

    public void clear(){
        for(int i = 0; i < pixels.length; i++){
            pixels[i] = 0;
        }
    }
    public void renderTile(int xp, int yp, Tile tile){
        xp -= xOffset;
        yp -= yOffset;
        for(int y = 0; y < tile.sprite.SIZE; y++){
            int ya = y + yp;
            for(int x = 0; x < tile.sprite.SIZE; x++){
                int xa = x + xp;
                if (xa < 0 - tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
                if(xa < 0) xa = 0;
                pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
            }
        }
    }

    public void setOffset(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
}
