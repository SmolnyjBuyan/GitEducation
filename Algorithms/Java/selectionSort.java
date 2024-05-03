import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {
        int[] sample = new int[] {2, 1, 5, 6, 9, 7, 8, 0};
        
        System.out.println(Arrays.toString(sort(sample)));
    }

    public static int[] sort(int[] array) {
        int smallestIndex;
        int temp;

        for (int i = 0; i < array.length - 1; i++) {
            smallestIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[smallestIndex]) {
                    smallestIndex = j;
                }
            }

            temp = array[smallestIndex];
            array[smallestIndex] = array[i];
            array[i] = temp;

            System.out.println(Arrays.toString(array));
        }

        return array;
    }
}