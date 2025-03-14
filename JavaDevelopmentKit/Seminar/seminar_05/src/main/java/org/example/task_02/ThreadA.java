package org.example.task_02;

public class ThreadA implements Runnable{
    private boolean switcher;

    @Override
    public void run() {
        while (true) {
            try {
                switcher = !switcher;
                System.out.println("Повернул");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("The End");
                break;
            }
        }
    }

    public synchronized boolean isSwitcher() {
        return switcher;
    }
}
