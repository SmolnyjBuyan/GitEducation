import java.util.Arrays;

public class Task_03 {
    public static void main(String[] args) {
        int[] array = new int[]{10, 3, 76, 34, 23, 32};

        HeapSort.heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}

class HeapSort {

    public static void buildTree(int[] array, int index, int sortLength) {
        int root = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < sortLength && array[left] > array[root]) {
            root = left;
        }

        if (right < sortLength && array[right] > array[root]) {
            root = right;
        }

        if (root != index) {
            int temp = array[root];
            array[root] = array[index];
            array[index] = temp;
            buildTree(array, root, sortLength);
        }
    }

    public static void heapSort(int[] sortArray) {
        for (int i = sortArray.length / 2 - 1; i >= 0; i--) {
            buildTree(sortArray, i, sortArray.length);
        }

        for (int i = sortArray.length - 1; i >= 0; i--) {
            int temp = sortArray[0];
            sortArray[0] = sortArray[i];
            sortArray[i] = temp;

            buildTree(sortArray, 0, i);
        }
    }
}