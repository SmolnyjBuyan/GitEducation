import java.util.Arrays;

public class Task_03 {
    public static void main(String[] args) {
        int[] array = new int[]{10, 3, 76, 34, 23, 32};

        // HeapSort.buildTree(array, 0);
        HeapSort.heapSort(array, 0);
        System.out.println(Arrays.toString(array));
    }
}

class HeapSort {
    public static void buildTree(int[] tree, int sortLength) {
        int largest = sortLength;
        int l = 2 * sortLength + 1;
        int r = 2 * sortLength + 2;

        if (l < tree.length && tree[l] > tree[largest]) {
            largest = l;
        }

        if (r < tree.length && tree[r] > tree[largest]) {
            largest = r;
        }

        if  (largest != sortLength) {
            int temp = tree[largest];
            tree[largest] = tree[sortLength];
            tree[sortLength] = temp;

            buildTree(tree, largest);
        }

    }

    public static void heapSort(int[] sortArray, int sortLength) {
        for (int i = sortArray.length / 2 - 1; i >= 0; i--) {
            buildTree(sortArray, sortLength);
        }
    }
}