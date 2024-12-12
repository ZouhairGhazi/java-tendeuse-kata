package com.solent.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MowerTest {

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

        mower.moveForward();

        // Assertions
        assertEquals(1, mower.getX(), "X-coordinate should remain the same when moving north");
        assertEquals(3, mower.getY(), "Y-coordinate should increase by 1 when moving north");
    }

    @Test
    public void shouldMoveForwardCorrectlyWhenFacingEast() {

        Mower mower = new Mower(1, 2, 'E');

        mower.moveForward();

        // Assertions
        assertEquals(2, mower.getX(), "X-coordinate should increase by 1 when moving east");
        assertEquals(2, mower.getY(), "Y-coordinate should remain the same when moving east");
    }

    @Test
    public void shouldMoveForwardCorrectlyWhenFacingSouth() {

        Mower mower = new Mower(1, 2, 'S');

        mower.moveForward();

        // Assertions
        assertEquals(1, mower.getX(), "X-coordinate should remain the same when moving south");
        assertEquals(1, mower.getY(), "Y-coordinate should decrease by 1 when moving south");
    }

    @Test
    public void shouldMoveForwardCorrectlyWhenFacingWest() {

        Mower mower = new Mower(1, 2, 'W');

        mower.moveForward();

        // Assertions
        assertEquals(0, mower.getX(), "X-coordinate should decrease by 1 when moving west");
        assertEquals(2, mower.getY(), "Y-coordinate should remain the same when moving west");
    }
}