package ru.smolny;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class App {
    public static void main(String[] args) {
        Person person = new Person("Andrey", "Kotov", 30);
        Person person2 = new Person("andrey", "kotov", 30);
        Person person3 = new Person("Sergey", "Kozhevin", 30);

        System.out.println("Объект №1: " + person);
        System.out.println("Объект №2: " + person2);
        System.out.println("Объект №3: " + person3);
        System.out.println("Равны ли объекты №1 и №2: "+ person.equals(person2));
        System.out.println("Равны ли объекты №1 и №3: "+ person.equals(person3));
        System.out.println("==================================================");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String personJson = gson.toJson(person);
        System.out.println("Сериализованный объект №1:");
        System.out.println(personJson);
        Person person4 = gson.fromJson(personJson, Person.class);
        System.out.println("Десериализованный объект №1 в объект №4:");
        System.out.println("Объект №4: " + person4);
        System.out.println("Равны ли объекты №1 и №4: "+ person.equals(person4));
        System.out.println("==================================================");

        File file = new File("target/person3.json");
        try (FileWriter writer = new FileWriter(file)){
            gson.toJson(person3, writer);
            System.out.println("Объект №3 успешно сериализован в " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader(file)){
            Person person5 = gson.fromJson(reader, Person.class);
            System.out.println("Объект №3 успешно десериализован в объект №5: ");
            System.out.println(person5);
            System.out.println("Равны ли объекты №3 и №5: "+ person3.equals(person5));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
