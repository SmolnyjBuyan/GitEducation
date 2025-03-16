package org.example;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Fork fork1 = new Fork(1);
        Fork fork2 = new Fork(2);
        Fork fork3 = new Fork(3);
        Fork fork4 = new Fork(4);
        Fork fork5 = new Fork(5);

        Philosopher philosopher1 = new Philosopher("Сергей", fork1, fork2);
        Philosopher philosopher2 = new Philosopher("Андрей", fork2, fork3);
        Philosopher philosopher3 = new Philosopher("Петр", fork3, fork4);
        Philosopher philosopher4 = new Philosopher("Алексей", fork4, fork5);
        Philosopher philosopher5 = new Philosopher("Игорь", fork5, fork1);

        Table table = new Table();
        table.add(philosopher1);
        table.add(philosopher2);
        table.add(philosopher3);
        table.add(philosopher4);
        table.add(philosopher5);

        table.start();
    }
}