package patterns.structural.wrappers.facade.solution;

import java.util.Arrays;

public class GBArrays<T extends Comparable<T>> {
    private final T[] array;

    public GBArrays(T[] array) {
        this.array = array;
    }

    public int search(T value) {
        return binarySearch(value, 0, array.length - 1);
    }

    public void sort() {
        sort(0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private int binarySearch(T value, int min, int max) {
        int mid;
        if (min > max) {
            return -1;
        } else {
            mid = (max - min) / 2 + min;
        }

        if (array[mid].compareTo(value) < 0) {
            return binarySearch(value, mid + 1, max);
        } else {
            if (array[mid].compareTo(value) > 0) {
                return binarySearch(value, min, mid - 1);
            } else return mid;
        }
    }

    private void sort(int startIndex, int endIndex) {
        if (startIndex > endIndex) return;
        int middleIndex = (endIndex - startIndex) / 2 + startIndex;

        T middleElement = array[middleIndex];
        int i = startIndex;
        int j = endIndex;

        while (i <= j) {
            while (array[i].compareTo(middleElement) < 0) i++;
            while (array[j].compareTo(middleElement) > 0) j--;

            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        sort(startIndex, j);
        sort(i, endIndex);
    }

    private void swap(int leftIndex, int rightIndex) {
        T temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }
}
