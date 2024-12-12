package com.solent.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MowerTest {

    @Test
    void shouldUpdateMowerPositionTurningLeftCorrectly() {

        char newOrientation = 'W';
        Mower mower = new Mower(1, 1, 'N');

        mower.turnLeft();

        assertEquals(newOrientation, mower.getOrientation(), "Mower orientation should be W");
    }
}