package org.example.task_02;

public class Main {
    public static void main(String[] args) {
        Box<Apple> apples = new Box<>();
        Box<Fruit> fruitBox = new Box<>();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);
    }
}
