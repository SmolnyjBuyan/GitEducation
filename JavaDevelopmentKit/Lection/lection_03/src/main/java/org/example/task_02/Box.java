package org.example.task_02;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {
    private final List<T> fruits = new ArrayList<>();

    public List<T> getFruits() {
        return fruits;
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }
    public void addAll(List<T> fruits) {
        this.fruits.addAll(fruits);
    }
    public float getWeight() {
        if (fruits.isEmpty()) return 0f;
        return fruits.size() * fruits.get(0).getWeight();
    }

//    public float getWeight() {
//        return fruits.stream().map(Fruit::getWeight).reduce(0f, Float::sum);
//    }

    public boolean compare(Box<? extends Fruit> box) {
        return getWeight() == box.getWeight();
    }

    public void moveFruitsTo(Box<T> box) {
        while (!fruits.isEmpty()) {
            box.add(fruits.remove(0));
        }
    }

    public void moveAllFruitsTo(Box<T> box) {
        box.addAll(getFruits());
        fruits.clear();
    }

    @Override
    public String toString() {
        return fruits.toString();
    }
}
