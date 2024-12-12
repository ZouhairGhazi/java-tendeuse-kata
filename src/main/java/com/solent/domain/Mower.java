package com.solent.domain;

public class Mower {

    private int x;
    private int y;
    private char orientation;

    public Mower(int x, int y, char orientation) {
        if (!isValidOrientation(orientation)) {
            throw new IllegalArgumentException("Invalid orientation: " + orientation);
        }
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

    private boolean isValidOrientation(char orientation) {
        return orientation == 'N' || orientation == 'E' || orientation == 'S' || orientation == 'W';
    }

    public void turnLeft() {
        switch (orientation) {
            case 'N' -> orientation = 'W';
            case 'W' -> orientation = 'S';
            case 'S' -> orientation = 'E';
            case 'E' -> orientation = 'N';
            default -> throw new IllegalStateException("Invalid orientation: " + orientation);
        }
    }

    public void turnRight() {
        switch (orientation) {
            case 'N' -> orientation = 'E';
            case 'E' -> orientation = 'S';
            case 'S' -> orientation = 'W';
            case 'W' -> orientation = 'N';
            default -> throw new IllegalStateException("Invalid orientation: " + orientation);
        }
    }
}
