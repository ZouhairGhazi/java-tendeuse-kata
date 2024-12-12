package com.solent.parser;

import com.solent.domain.Grid;
import com.solent.domain.Mower;
import com.solent.dto.ParsedInput;

import java.util.List;

public class LawnMowerInputParser {

    public ParsedInput parse(String fileContent) {

        String[] fileContentList = fileContent.split("\n");

        // Parse grid dimensions (first line)
        String[] gridDimensions = fileContentList[0].split(" ");
        int width = Integer.parseInt(gridDimensions[0]);
        int height = Integer.parseInt(gridDimensions[1]);

        // Creating grid using parsed dimensions
        Grid grid = new Grid(width, height);

        // Create dummy values for the rest of ParsedInput
        Mower dummyMower = new Mower(0, 0, 'N'); // Placeholder mower
        List<Character> dummyCommands = List.of(); // Placeholder commands

        // Return the ParsedInput object
        return new ParsedInput(grid, dummyMower, dummyCommands);
    }
}
