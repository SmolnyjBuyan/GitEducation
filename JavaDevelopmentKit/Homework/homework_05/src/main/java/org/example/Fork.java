package org.example;

import java.util.concurrent.locks.ReentrantLock;

public class  Fork extends ReentrantLock {
    private final int id;

    public Fork(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
