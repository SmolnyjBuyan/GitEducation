package task_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Race extends Thread{
    private final List<Runner> runners = new ArrayList<>();

    public void add(Runner runner) {
        runners.add(runner);
    }

    @Override
    public void run() {
        CountDownLatch cdl = new CountDownLatch(runners.size());
        runners.forEach(runner -> runner.setCdl(cdl));
        runners.forEach(Runner::start);
        try {
            cdl.await();
            prepareToRace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void prepareToRace() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("На старт!");
        Thread.sleep(1000);
        System.out.println("Внимание!");
        Thread.sleep(1000);
        System.out.println("Марш!");
    }
}
