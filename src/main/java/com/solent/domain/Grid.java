package com.solent.domain;

public class Grid {

    private final int width;
    private final int height;

    public Grid(int maxX, int maxY) {
        width = maxX;
        height = maxY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
