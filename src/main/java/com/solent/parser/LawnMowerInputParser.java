package com.solent.parser;

import com.solent.domain.Grid;
import com.solent.domain.Mower;
import com.solent.dto.ParsedInput;

import java.util.ArrayList;
import java.util.List;

public class LawnMowerInputParser {

    public ParsedInput parse(String fileContent) {

        try {

            String[] fileContentList = fileContent.split("\\r?\\n");

            // Parse grid dimensions
            String[] gridDimensions = fileContentList[0].split(" ");
            if (gridDimensions.length != 2) {
                throw new IllegalArgumentException("Invalid grid dimensions: " + fileContentList[0]);
            }

            // Creating grid using parsed data
            int width = Integer.parseInt(gridDimensions[0]);
            int height = Integer.parseInt(gridDimensions[1]);
            Grid grid = new Grid(width, height);

            // Parse mowers and commands
            List<Mower> mowers = new ArrayList<>();
            List<List<Character>> commands = new ArrayList<>();

            for (int i = 1; i < fileContentList.length; i += 2) {
                String[] moverDetails = fileContentList[i].split(" ");

                if (moverDetails.length != 3) {
                    throw new IllegalArgumentException("Invalid mower info: " + fileContentList[i]);
                }

                int x = Integer.parseInt(moverDetails[0]);
                int y = Integer.parseInt(moverDetails[1]);
                char orientation = moverDetails[2].charAt(0);

                Mower mower = new Mower(x, y, orientation);
                mowers.add(mower);

                // Parse commands for this mower
                String commandString = fileContentList[i + 1];
                List<Character> commandList = commandString.chars()
                        .mapToObj(c -> (char) c)
                        .toList();
                commands.add(commandList);
            }

            return new ParsedInput(grid, mowers, commands);
        } catch (Exception e) {
            System.err.println("Error during parsing: " + e.getMessage());
            throw e;
        }
    }
}
