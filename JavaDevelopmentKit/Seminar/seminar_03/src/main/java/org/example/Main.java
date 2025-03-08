package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

        MyOwnCollection<Integer> myOwnCollection = new MyOwnCollection<>();
        for (int i = 0; i < 11; i++) {
            myOwnCollection.add(i);
        }
        System.out.println(myOwnCollection);

        myOwnCollection.remove(4);
        System.out.println(myOwnCollection);
        myOwnCollection.add(29);
        System.out.println(myOwnCollection);
    }
}