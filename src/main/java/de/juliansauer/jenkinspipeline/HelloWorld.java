package de.juliansauer.jenkinspipeline;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HelloWorld {

    public static void main(String[] args) throws IOException {
        String path = "DemoFile.txt";
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String currentDate = format.format(date);

        System.out.println("Writing a demo file at " + currentDate + " to " + path);
        createDemoFile(path, Arrays.asList("This file was written at:", currentDate));
    }

    static void createDemoFile(String filePath, Iterable content) throws IOException {
        Path path = Paths.get(filePath);
        Files.write(path, content, Charset.defaultCharset());
    }

}
