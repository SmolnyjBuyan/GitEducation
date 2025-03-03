package org.example.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileData implements Repository{
    private final Path LOG_HISTORY_FILE_PATH = Paths.get("src/main/resources/history");
    private final Users users;

    public FileData() {
        validateLogFile();
        users = new Users();
    }

    @Override
    public String readLogs() {
        StringBuilder chatHistory = new StringBuilder();

        try (BufferedReader reader = Files.newBufferedReader(LOG_HISTORY_FILE_PATH)) {
            String line;
            while ((line = reader.readLine()) != null) {
                chatHistory.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return chatHistory.toString();
    }

    @Override
    public boolean isUserValid(String name, String password) {
        return users.isUserValid(name, password);
    }

    @Override
    public void addMessage(String s) {
        try {
            Files.write(LOG_HISTORY_FILE_PATH, s.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void validateLogFile() {
        if (!Files.exists(LOG_HISTORY_FILE_PATH)) {
            try {
                Files.createFile(LOG_HISTORY_FILE_PATH);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
