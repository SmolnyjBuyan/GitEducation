package org.example;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Class<?> clazz = String.class;

        AtomicInteger index = new AtomicInteger();
        Arrays.stream(clazz.getDeclaredMethods()).forEach(s -> System.out.println(index.incrementAndGet() + ". " + s));
    }
}