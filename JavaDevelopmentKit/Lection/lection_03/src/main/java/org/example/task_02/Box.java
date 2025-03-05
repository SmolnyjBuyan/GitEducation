package org.example.task_02;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {
    List<T> fruits = new ArrayList<>();

    public void add(T fruit) {
        fruits.add(fruit);
    }
}
