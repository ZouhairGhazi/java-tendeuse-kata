package com.solent.runner;

import com.solent.domain.Grid;
import com.solent.domain.Mower;
import com.solent.dto.ParsedInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LawnMowerRunnerTest {

    private Grid grid;

    @BeforeEach
    public void setUp() {
        grid = new Grid(5, 5);
    }

    @Test
    public void shouldHandleSimpleForwardCommandsForMultipleMowers() {

        Mower mower = new Mower(2, 2, 'N');

        List<Character> commands1 = List.of('A', 'A', 'A'); // Mower 1 moves north

        ParsedInput parsedInput = new ParsedInput(grid, List.of(mower), List.of(commands1));

        LawnMowerRunner runner = new LawnMowerRunner();
        runner.runSimulation(parsedInput);

        // Assertions
        assertEquals(2, mower.getX(), "Mower 1 x should remain unchanged");
        assertEquals(5, mower.getY(), "Mower 1 y should be at the top boundary");
        assertEquals('N', mower.getOrientation(), "Mower 1 should remain facing North");

    }

    @Test
    public void shouldThrowExceptionForInvalidCommandForAnyMower() {

        Mower mower1 = new Mower(0, 0, 'N');
        Mower mower2 = new Mower(1, 1, 'E');

        List<Character> commands1 = List.of('A', 'A', 'X'); // Mower 1 has an invalid command
        List<Character> commands2 = List.of('A', 'A', 'A'); // Mower 2 has valid commands

        ParsedInput parsedInput = new ParsedInput(grid, List.of(mower1, mower2), List.of(commands1, commands2));
        LawnMowerRunner runner = new LawnMowerRunner();

        assertThrows(IllegalArgumentException.class, () -> runner.runSimulation(parsedInput),
                "Should throw exception for invalid command 'X'");
    }

    @Test
    public void shouldExecuteCommandsForMultipleMowersAndEndInCorrectPositions() {

        Mower mower = new Mower(1, 2, 'N');

        List<Character> commands1 = List.of('G', 'A', 'A', 'D', 'A'); // Mower 1 commands

        ParsedInput parsedInput = new ParsedInput(grid, List.of(mower), List.of(commands1));

        LawnMowerRunner runner = new LawnMowerRunner();
        runner.runSimulation(parsedInput);

        // Assertions
        assertEquals(0, mower.getX(), "Mower 1 should end at x=0");
        assertEquals(3, mower.getY(), "Mower 1 should end at y=3");
        assertEquals('N', mower.getOrientation(), "Mower 1 should end facing North");

    }
}
