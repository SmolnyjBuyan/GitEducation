package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(Calculator.sum(89232L, 100f));
        System.out.println(Calculator.multiply(89232L, 100f));
        System.out.println(Calculator.divide(89232L, 100f));
        System.out.println(Calculator.subtract(89232L, 10000f));

        String[] strings = {"first", "second", "third", "fourth"};
        Integer[] integers = {1, 2, 3, 4};
        Number[] integers2 = {10, 20, 30, 40};
        System.out.println(compareArrays(integers, integers2));
        System.out.println(compareArrays(integers, strings));

        Pair<String, Double> pair = new Pair<>("First", 1000D);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
        System.out.println(pair);
    }

    public static <T> boolean compareArrays(T[] array, T[] array2) {
        if (array.length != array2.length) return false;
        for (int i = 0; i < array.length; i++) {
            if (!array[i].getClass().equals(array2[i].getClass())) return false;
        }
        return true;
    }
}