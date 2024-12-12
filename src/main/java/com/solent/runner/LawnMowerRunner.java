package com.solent.runner;

import com.solent.domain.Grid;
import com.solent.domain.Mower;
import com.solent.dto.ParsedInput;

import java.util.List;

public class LawnMowerRunner {

    public void runSimulation(ParsedInput parsedInput) {
        Grid grid = parsedInput.grid();
        List<Mower> mowers = parsedInput.mowers();
        List<List<Character>> allCommands = parsedInput.commands();

        for (int i = 0; i < mowers.size(); i++) {
            Mower mower = mowers.get(i);
            List<Character> commands = allCommands.get(i);

            for (char command : commands) {
                switch (command) {
                    case 'G' -> mower.turnLeft();
                    case 'D' -> mower.turnRight();
                    case 'A' -> mower.moveForward(grid);
                    default -> throw new IllegalArgumentException("Invalid command: " + command);
                }
            }
        }
    }
}
