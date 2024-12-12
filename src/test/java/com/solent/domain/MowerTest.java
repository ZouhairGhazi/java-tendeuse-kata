package com.solent.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MowerTest {

    @Test
    void shouldUpdateMowerOrientationTurningLeftCorrectly() {

        char newOrientation = 'W';
        Mower mower = new Mower(1, 1, 'N');

        mower.turnLeft();

        assertEquals(newOrientation, mower.getOrientation(), "Mower orientation should be W");
    }

    @Test
    void shouldUpdateMowerOrientationTurningRightCorrectly() {

        char newOrientation = 'E';
        Mower mower = new Mower(1, 1, 'N');

        mower.turnRight();

        assertEquals(newOrientation, mower.getOrientation(), "Mower orientation should be E");
    }
}