package org.example.task_02;

public class Task_02 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Fruit> fruitBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        appleBox.add(apple1);
        appleBox.add(apple2);
        appleBox.add(apple3);

        orangeBox.add(orange1);
        orangeBox.add(orange2);

        Box<Apple> appleBox2 = new Box<>();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();
        appleBox2.add(apple4);
        appleBox2.add(apple5);

        System.out.println(appleBox);
        System.out.println(appleBox2);

        appleBox.moveAllFruitsTo(appleBox2);
        System.out.println(appleBox);
        System.out.println(appleBox2);
    }
}
