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

        // Creating grid using parsed data
        Grid grid = new Grid(width, height);

        // Parse mower position and orientation (second line)
        String[] moverDetails = fileContentList[1].split(" ");
        int x = Integer.parseInt(moverDetails[0]);
        int y = Integer.parseInt(moverDetails[1]);
        char orientation = moverDetails[2].charAt(0);

        // Creating mower using parsed data
        Mower mower = new Mower(x, y, orientation); // Placeholder mower

        // Create dummy values for the rest of ParsedInput
        List<Character> dummyCommands = List.of(); // Placeholder commands

        // Return the ParsedInput object
        return new ParsedInput(grid, mower, dummyCommands);
    }
}
