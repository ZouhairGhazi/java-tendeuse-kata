package com.solent.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MowerTest {

    private Grid grid;

    @BeforeEach
    public void setUp() {
        grid = new Grid(5, 5);
    }

    @Test
    void shouldUpdateMowerOrientationTurningLeftCorrectly() {

        char newOrientation = 'W';
        Mower mower = new Mower(1, 1, 'N');

        mower.turnLeft();

        // Assertion
        assertEquals(newOrientation, mower.getOrientation(), "Mower orientation should be W");
    }

    @Test
    void shouldUpdateMowerOrientationTurningRightCorrectly() {

        char newOrientation = 'E';
        Mower mower = new Mower(1, 1, 'N');

        mower.turnRight();

        // Assertion
        assertEquals(newOrientation, mower.getOrientation(), "Mower orientation should be E");
    }

    @Test
    public void shouldMoveForwardCorrectlyWhenFacingNorth() {

        Mower mower = new Mower(1, 2, 'N');

        mower.moveForward(grid);

        // Assertions
        assertEquals(1, mower.getX(), "X-coordinate should remain the same when moving north");
        assertEquals(3, mower.getY(), "Y-coordinate should increase by 1 when moving north");
    }

    @Test
    public void shouldMoveForwardCorrectlyWhenFacingEast() {

        Mower mower = new Mower(1, 2, 'E');

        mower.moveForward(grid);

        // Assertions
        assertEquals(2, mower.getX(), "X-coordinate should increase by 1 when moving east");
        assertEquals(2, mower.getY(), "Y-coordinate should remain the same when moving east");
    }

    @Test
    public void shouldMoveForwardCorrectlyWhenFacingSouth() {

        Mower mower = new Mower(1, 2, 'S');

        mower.moveForward(grid);

        // Assertions
        assertEquals(1, mower.getX(), "X-coordinate should remain the same when moving south");
        assertEquals(1, mower.getY(), "Y-coordinate should decrease by 1 when moving south");
    }

    @Test
    public void shouldMoveForwardCorrectlyWhenFacingWest() {

        Mower mower = new Mower(1, 2, 'W');

        mower.moveForward(grid);

        // Assertions
        assertEquals(0, mower.getX(), "X-coordinate should decrease by 1 when moving west");
        assertEquals(2, mower.getY(), "Y-coordinate should remain the same when moving west");
    }

    @Test
    public void shouldNotMoveBeyondNorthBoundary() {

        Mower mower = new Mower(2, 5, 'N'); // Positioned at the top edge of the grid

        mower.moveForward(grid); // Try to move north beyond boundary

        // Assertion
        assertEquals(2, mower.getX(), "X-coordinate should remain unchanged");
        assertEquals(5, mower.getY(), "Y-coordinate should stay at the north boundary");
    }

    @Test
    public void shouldNotMoveBeyondSouthBoundary() {

        Mower mower = new Mower(2, 0, 'S'); // Positioned at the bottom edge of the grid

        mower.moveForward(grid); // Try to move south beyond boundary

        // Assertion
        assertEquals(2, mower.getX(), "X-coordinate should remain unchanged");
        assertEquals(0, mower.getY(), "Y-coordinate should stay at the south boundary");
    }

    @Test
    public void shouldNotMoveBeyondEastBoundary() {

        Mower mower = new Mower(5, 2, 'E'); // Positioned at the right edge of the grid

        mower.moveForward(grid); // Try to move east beyond boundary

        // Assertion
        assertEquals(5, mower.getX(), "X-coordinate should stay at the east boundary");
        assertEquals(2, mower.getY(), "Y-coordinate should remain unchanged");
    }

    @Test
    public void shouldNotMoveBeyondWestBoundary() {

        Mower mower = new Mower(0, 2, 'W'); // Positioned at the left edge of the grid

        mower.moveForward(grid); // Try to move west beyond boundary

        // Assertion
        assertEquals(0, mower.getX(), "X-coordinate should stay at the west boundary");
        assertEquals(2, mower.getY(), "Y-coordinate should remain unchanged");
    }
}