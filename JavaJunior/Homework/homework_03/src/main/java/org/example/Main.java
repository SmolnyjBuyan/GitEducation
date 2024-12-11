package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Student toSerialize = new Student("Bob", 22, 4.4);
        System.out.println(toSerialize);
        serialize(toSerialize, "src/main/resources/data.txt");
        System.out.println("==================================");
        Student toDeSerialize = deSerialize("src/main/resources/data.txt");
        System.out.println(toDeSerialize);

    }

    public static void serialize(Student student, String filePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(student);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Student deSerialize(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (Student) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}