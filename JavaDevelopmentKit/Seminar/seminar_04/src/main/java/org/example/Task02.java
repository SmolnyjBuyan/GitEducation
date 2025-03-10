package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Task02 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList
                ("Андрей", "Татьяна", "Дарья", "Дарья", "Петр", "Дмитрий", "Петр", "Василий"));
        Set<String> uniqueNames = new HashSet<>(names);
        System.out.println(uniqueNames);
        System.out.println("Min element: " + uniqueNames.stream().sorted().findFirst().orElse(null));
        System.out.println("Min element: " + uniqueNames.stream().min(Comparator.naturalOrder()).orElse(null));
        System.out.println("Min element: " + uniqueNames.stream().max
                (Comparator.comparing(String::length).reversed()).orElse(null));
        uniqueNames.removeAll(uniqueNames.stream().filter(e -> e.contains("А")).collect(Collectors.toSet()));
        System.out.println(uniqueNames);
        uniqueNames.removeIf(e  -> e.contains("Д"));
        System.out.println(uniqueNames);
    }
}
