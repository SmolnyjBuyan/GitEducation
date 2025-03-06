package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try (DataInputStream fileInputStream = new DataInputStream
                (Files.newInputStream(Paths.get("src/main/resources/task_01")))) {
            Parametrized<String, DataInputStream, Double> parametrized =
                    new Parametrized<>("task-01",fileInputStream, 234D);
            parametrized.printVariablesClassNames();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}