package com.solent.domain;

public class Mower {

    private int x;
    private int y;
    private char orientation;

    public Mower(int x, int y, char orientation) {
        if (!isValidOrientation(orientation)) {
            throw new IllegalArgumentException("Invalid orientation: " + orientation);
        }
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Coordinates must be non-negative: x=" + x + ", y=" + y);
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

    public void moveForward() {
        switch (orientation) {
            case 'N' -> y += 1; // Move up (north increases y-coordinate)
            case 'E' -> x += 1; // Move right (east increases x-coordinate)
            case 'S' -> y -= 1; // Move down (south decreases y-coordinate)
            case 'W' -> x -= 1; // Move left (west decreases x-coordinate)
            default -> throw new IllegalStateException("Invalid orientation: " + orientation);
        }
    }
}
