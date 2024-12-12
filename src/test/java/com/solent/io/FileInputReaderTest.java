package com.solent.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileInputReaderTest {

    @TempDir
    Path tempDir;

    @Test
    public void shouldReadFileContent() throws IOException, URISyntaxException {

        Path testFile = tempDir.resolve("input.txt");
        String expectedContent = "5 5\n1 2 N\nGAADA";
        Files.writeString(testFile, expectedContent);

        FileInputReader reader = new FileInputReader();
        String result = reader.readFileContent(testFile.toString());

        // Assertion
        assertEquals(expectedContent, result, "File content should match the expected string");
    }

    @Test
    public void shouldThrowIOExceptionForInvalidFile() {

        FileInputReader reader = new FileInputReader();
        String invalidPath = "non_existent_file.txt";

        // Assertion
        assertThrows(IOException.class, () -> reader.readFileContent(invalidPath),
                "Should throw IOException when file does not exist");
    }

}