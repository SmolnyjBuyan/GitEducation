package org.example.task_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task_01 {
    private static <T> void replace(T[] array, int indexFrom, int indexTo) {
        T temp = array[indexTo];
        array[indexTo] = array[indexFrom];
        array[indexFrom] = temp;
    }

    public static void main(String[] args) {
        String[] strings = {"first", "second", "third"};
        Integer[] integers = {1, 2, 3};
        replace(strings, 1, 2);
        replace(integers, 0, 1);
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(integers));
    }
    public static void swap(List<?> list, int srcIndex, int destIndex) {
        list.set(srcIndex, list.set(destIndex, list.get(srcIndex)));
    }

}
