package org.example;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<Philosopher> philosophers = new ArrayList<>();

    public void add(Philosopher philosopher) {
        philosophers.add(philosopher);
    }

    public void start() {
        philosophers.forEach(Philosopher::start);
    }
}
