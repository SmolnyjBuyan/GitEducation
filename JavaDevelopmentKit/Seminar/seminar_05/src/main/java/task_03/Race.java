package task_03;

import java.util.ArrayList;
import java.util.List;

public class Race extends Thread{
    private final List<Runner> runners = new ArrayList<>();


    public void add(Runner runner) {
        runners.add(runner);
    }

    @Override
    public void run() {
        runners.forEach(Runner::start);
        while (runners.stream().anyMatch(Runner::isNotReadyToStart)) {
            System.out.println("Ожидаем");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notifyAll();
    }
}
