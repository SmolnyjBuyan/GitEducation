package task_03;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner extends Thread{
    private final Random random;
    private boolean isReadyToStart;
    private boolean isFinish;
    private final String name;
    private int time;
    private CountDownLatch cdl;
    private final Race race;

    public Runner(String name, Race race) {
        this.name = name;
        random = new Random();
        this.race = race;
    }

    @Override
    public void run() {
        try {
            getReadyToStart();
            cdl.countDown();
            synchronized (race) {
                race.wait();
            }
            startRace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void getReadyToStart() throws InterruptedException {
        Thread.sleep(random.nextInt(10000));
        isReadyToStart = true;
        System.out.println(name + " готов к старту");
    }

    private void startRace() throws InterruptedException {
        System.out.println(name + " побежал!");
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

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }
}
