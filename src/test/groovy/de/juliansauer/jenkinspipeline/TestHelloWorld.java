package de.juliansauer.jenkinspipeline;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TestHelloWorld {

    @Test
    public void testCreateDemoFile() throws IOException {
        System.out.println("Testing createDemoFile:");
        String filePath = "TestFile.txt";
        String currentDate = "01/01/2000 00:00:00";
        System.out.println("    Writing test file");
        List<String> content = Arrays.asList("This file was written at:", currentDate);

        HelloWorld.createDemoFile("TestFile.txt", content);
        Path path = Paths.get(filePath);
        Assert.assertTrue(Files.exists(path));

        List<String> actualContent = Files.readAllLines(path);
        for (String c : content)
            Assert.assertTrue(actualContent.contains(c));

        System.out.println("    Deleting test file");
        Files.delete(path);
    }

}
