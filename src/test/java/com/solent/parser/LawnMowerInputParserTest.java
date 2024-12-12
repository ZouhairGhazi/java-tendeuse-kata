package com.solent.parser;

import com.solent.dto.ParsedInput;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LawnMowerInputParserTest {

    @Test
    void shouldParseGridDimensionsFromInput() {

        String input = "5 5\n1 2 N\nGAADA";
        LawnMowerInputParser parser = new LawnMowerInputParser();


        ParsedInput result = parser.parse(input);

        // Assertions
        assertNotNull(result, "ParsedInput should not be null");
        assertNotNull(result.grid(), "Grid should not be null");
        assertEquals(5, result.grid().getWidth(), "Grid width should be 5");
        assertEquals(5, result.grid().getHeight(), "Grid height should be 5");
    }

    @Test
    public void shouldParseMowerPositionAndOrientationFromInput() {

        String input = "5 5\n1 2 N\nGAADA";
        LawnMowerInputParser parser = new LawnMowerInputParser();

        ParsedInput result = parser.parse(input);

        // Assertions
        assertNotNull(result, "ParsedInput should not be null");
        assertNotNull(result.mowers().get(0), "Mower should not be null");
        assertEquals(1, result.mowers().get(0).getX(), "Mower X-coordinate should be 1");
        assertEquals(2, result.mowers().get(0).getY(), "Mower Y-coordinate should be 2");
        assertEquals('N', result.mowers().get(0).getOrientation(), "Mower orientation should be 'N'");
    }

    @Test
    public void shouldParseCommandsFromInput() {

        String input = "5 5\n1 2 N\nGAADA";
        LawnMowerInputParser parser = new LawnMowerInputParser();

        ParsedInput result = parser.parse(input);

        // Assertions
        assertNotNull(result, "ParsedInput should not be null");
        assertNotNull(result.commands(), "Commands list should not be null");
        assertEquals(List.of('G', 'A', 'A', 'D', 'A'), result.commands().get(0), "Commands should match expected sequence");
    }
}