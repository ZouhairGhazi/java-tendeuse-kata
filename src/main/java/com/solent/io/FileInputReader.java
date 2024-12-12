package com.solent.io;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileInputReader {

    public String readFileContent(String filePath) throws IOException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(filePath);
        if (resource != null) {
            filePath = Paths.get(resource.toURI()).toString(); // Dynamically resolve the resource path
        }
        return Files.readString(Path.of(filePath));
    }
}
