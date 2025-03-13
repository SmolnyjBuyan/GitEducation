package org.example;

public class TicTakToe implements Runnable{
    private static int turn = 1;
    private static int count;
    private final int order;
    private final Object monitor;


    public TicTakToe() {
        this.order = ++count;
        this.monitor = TicTakToe.class;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (monitor) {
                try {
                    while (turn != order) {
                        monitor.wait();
                    }
                    System.out.println(order);
                    Thread.sleep(300);
                    turn = (turn % count) + 1;
                    monitor.notifyAll();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
