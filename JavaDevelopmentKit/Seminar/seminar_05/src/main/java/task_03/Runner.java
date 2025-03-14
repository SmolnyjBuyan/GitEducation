package task_03;

import java.util.Random;

public class Runner extends Thread{
    private Random random;
    private boolean isReadyToStart;
    private boolean isFinish;
    private String name;
    private int time;
    private final Object monitor;

    public Runner(String name) {
        this.name = name;
        random = new Random();
        monitor = Race.class;
    }

    @Override
    public void run() {
        try {
            getReadyToStart();
            synchronized (monitor) {
                wait();
            }
            startRace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void getReadyToStart() throws InterruptedException {
        Thread.sleep(random.nextInt(10000));
        isReadyToStart = true;
        System.out.println(name + "  готов к старту");
    }

    private void startRace() throws InterruptedException {
        time = random.nextInt(20000);
        Thread.sleep(time);
        System.out.println(name + " финишировал со временем:" + time / 1000 + " секунд");
        isFinish = true;
    }

    public boolean isReadyToStart() {
        return isReadyToStart;
    }

    public boolean isNotReadyToStart() {
        return !isReadyToStart;
    }
}
