package com.solent.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    public void shouldReturnTrueForPositionWithinBounds() {

        Grid grid = new Grid(5, 5);

        // Assertions
        assertTrue(grid.isWithinBounds(3, 3));
        assertTrue(grid.isWithinBounds(1, 4));
        assertTrue(grid.isWithinBounds(0, 0));
        assertTrue(grid.isWithinBounds(5, 5));
    }

    @Test
    public void shouldReturnFalseForPositionOutOfBounds() {

        Grid grid = new Grid(5, 5);

        // Assertions
        assertFalse(grid.isWithinBounds(-1, 3));
        assertFalse(grid.isWithinBounds(6, 3));
        assertFalse(grid.isWithinBounds(3, -1));
        assertFalse(grid.isWithinBounds(3, 6));
    }

    @Test
    public void shouldHandleLargeGridsCorrectly() {

        Grid grid = new Grid(100, 100);

        // Assertions
        assertTrue(grid.isWithinBounds(50, 50), "Position (50, 50) should be within bounds in a large grid");
        assertFalse(grid.isWithinBounds(101, 50), "Position (101, 50) should be out of bounds in a large grid");
        assertFalse(grid.isWithinBounds(50, 101), "Position (50, 101) should be out of bounds in a large grid");
    }

}