package com.solent.parser;

import com.solent.dto.ParsedInput;
import org.junit.jupiter.api.Test;

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
}