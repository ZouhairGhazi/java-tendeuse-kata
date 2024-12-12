package com.solent.domain;

public class Mower {

    private final int x;
    private final int y;
    private final char orientation;

    public Mower(int x, int y, char orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getOrientation() {
        return orientation;
    }
}
