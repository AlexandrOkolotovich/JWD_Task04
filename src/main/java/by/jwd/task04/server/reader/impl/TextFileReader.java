package by.jwd.task04.server.reader.impl;

import by.jwd.task04.server.reader.ReaderFromFile;

import java.io.*;

public class TextFileReader implements ReaderFromFile {

    @Override
    public String takeText(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder text = new StringBuilder();
        while (reader.ready()){
            text.append(reader.readLine().trim());
        }
        return text.toString();
    }
}
