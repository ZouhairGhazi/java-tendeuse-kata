package com.solent;

import com.solent.domain.Mower;
import com.solent.dto.ParsedInput;
import com.solent.io.FileInputReader;
import com.solent.parser.LawnMowerInputParser;
import com.solent.runner.LawnMowerRunner;

public class Main {
    public static void main(String[] args) {
        try {

            // Path to the test file in resources
            String filePath = "test.txt";

            // 1. Read file content
            FileInputReader reader = new FileInputReader();
            String fileContent = reader.readFileContent(filePath);

            // 2. Parse the input
            LawnMowerInputParser parser = new LawnMowerInputParser();
            ParsedInput parsedInput = parser.parse(fileContent);

            // 3. Run the simulation
            LawnMowerRunner runner = new LawnMowerRunner();
            runner.runSimulation(parsedInput);

            // 4. Print final mowers' states
            String mowerNumber = "";
            for (int i = 0; i < parsedInput.mowers().size(); i++) {
                Mower mower = parsedInput.mowers().get(i);
                switch (i) {
                    case 0 -> mowerNumber = "st";
                    case 1 -> mowerNumber = "nd";
                    case 2 -> mowerNumber = "rd";
                    default -> mowerNumber = "th";
                }
                System.out.println(" The " + (i+1) + mowerNumber + " Mower Position: "
                        + mower.getX() + " "
                        + mower.getY() + " "
                        + mower.getOrientation());
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}