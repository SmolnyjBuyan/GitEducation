package org.example;

import java.io.*;

public class Main_Ex {
    public static void main(String[] args) {
        Student_Ex toSerialize = new Student_Ex("Bob", 22, 4.4);
        System.out.println(toSerialize);
        serialize(toSerialize, "src/main/resources/data_ex.txt");
        System.out.println("==================================");
        Student_Ex toDeSerialize = new Student_Ex();
        deSerialize(toDeSerialize, "src/main/resources/data_ex.txt");
        System.out.println(toDeSerialize);

    }

    public static void serialize(Student_Ex student, String filePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            student.writeExternal(objectOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deSerialize(Student_Ex student, String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            student.readExternal(objectInputStream);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
