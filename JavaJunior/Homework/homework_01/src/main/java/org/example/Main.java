package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers =  IntStream.range(0, 20)
                .map(n -> (int) (Math.random() * 100))
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Исходный список: " + numbers);

        System.out.printf("Среднее значение: %.2f",
                numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .average().orElse(0.0));
    }
}