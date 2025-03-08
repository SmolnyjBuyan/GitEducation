package org.example;

import java.util.Arrays;

public class MyOwnCollection<T> {
    private Object[] array;
    int size;

    public MyOwnCollection() {
        array = new Object[10];
    }

    public void add(T element) {
        if (size == array.length) grow();
        array[size++] = element;
    }
    public void remove(int index) {
        if (rangeCheck(index)) return;
        int numMoved = size - index - 1;
        System.arraycopy(array, index + 1, array, index, numMoved);
        array[--size] = null;
    }

    private void grow() {

        array = Arrays.copyOf(array, array.length * 2);
    }

    private boolean rangeCheck(int index) {
        return index >= array.length || index < 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
