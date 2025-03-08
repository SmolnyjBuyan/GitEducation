package org.example;

import java.util.Iterator;
import java.util.List;

public class GenericIterator <T> implements Iterator<T> {
    private final List<T> list;
    private int currentIndex;

    public GenericIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < list.size();
    }

    @Override
    public T next() {
        return list.get(currentIndex++);
    }
}
