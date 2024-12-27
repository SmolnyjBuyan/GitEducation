package org.example;

import antlr.collections.List;
import com.mysql.cj.ServerPreparedQuery;
import javafx.event.Event;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.security.auth.login.Configuration;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();

        dataBase.create(new Course("GO", 300));
        dataBase.create(new Course("Java", 250));
        dataBase.create(new Course("Python", 200));

        dataBase.getCourses().forEach(System.out::println);


        Course courseToUpdate = dataBase.getCourseById(2);

        System.out.println(courseToUpdate);
        courseToUpdate.setTitle("JavaScript");
        dataBase.update(courseToUpdate);

        Course courseAfterUpdate = dataBase.getCourseById(2);
        System.out.println(courseAfterUpdate);

        dataBase.getCourses().forEach(System.out::println);

        Course courseToRemove = dataBase.getCourseById(3);
        dataBase.remove(courseToRemove);
        dataBase.getCourses().forEach(System.out::println);




    }
}