package org.example;

import java.util.Random;

public class Philosopher extends Thread {
    private final String name;
    private final Fork left;
    private final Fork right;

    private int counter;

    public Philosopher(String name, Fork left, Fork right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (counter < 3) {
            try {
                think();
                eat();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " завершил прием пищи");
    }

    private void think() throws InterruptedException {
        System.out.println(name + " размышляет");
        Thread.sleep(new Random().nextInt(10000));
    }

    private void eat() throws InterruptedException {
        if (left.tryLock()) {
            if (right.tryLock()) {
                    takeForks();
                    System.out.println(name + " кушает");
                    Thread.sleep(new Random().nextInt(10000));
                    System.out.println(name + " покушал");
                    counter++;
                    right.unlock();
            }
            left.unlock();
        }
    }

    private void takeForks() throws InterruptedException {
        System.out.printf("%s взял вилки: %s и %s" + System.lineSeparator(), name, left, right);
        Thread.sleep(new Random().nextInt(1000));
    }
}
