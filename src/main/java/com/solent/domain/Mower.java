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

    public void moveForward(Grid grid) {
        switch (orientation) {
            case 'N' -> {
                if (grid.isWithinBounds(x, y + 1)) {
                    y += 1;
                }
            }
            case 'E' -> {
                if (grid.isWithinBounds(x + 1, y)) {
                    x += 1;
                }
            }
            case 'S' -> {
                if (grid.isWithinBounds(x, y - 1)) {
                    y -= 1;
                }
            }
            case 'W' -> {
                if (grid.isWithinBounds(x - 1, y)) {
                    x -= 1;
                }
            }
            default -> throw new IllegalStateException("Invalid orientation: " + orientation);
        }
    }
}
