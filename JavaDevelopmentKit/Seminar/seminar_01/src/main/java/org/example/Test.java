package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
    private static final String FILE_NAME = "src/main/resources/history";

    public static void main(String[] args) {
        Path chatHistoryFilePath = Paths.get(FILE_NAME);
        StringBuilder chatHistory = new StringBuilder();

        try (BufferedReader reader = Files.newBufferedReader(chatHistoryFilePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                chatHistory.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(chatHistory);

    }
}
