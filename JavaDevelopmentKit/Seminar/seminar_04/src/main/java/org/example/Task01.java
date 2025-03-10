package org.example;

import java.util.*;

public class Task01 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList
                ("Андрей", "Татьяна", "Дарья", "Николай", "Евгений", "Дмитрий", "Петр", "Василий"));
        System.out.println(names);
        names.sort(Comparator.comparingInt(String::length));
        System.out.println(names);
        Collections.reverse(names);
        System.out.println(names);
    }
}