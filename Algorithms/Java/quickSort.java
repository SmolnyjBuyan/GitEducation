import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] array = new int[] {2, 5, 1, 8, 10, 4, 5, 43, 1, 3, 45, 43, 76, 6, 0};

        System.out.println(Arrays.toString(sort(array)));
    }

    private static int[] sort(int[] array) {
        return sort(array, 0, array.length - 1);
    }

    private static int[] sort(int[] array, int begin, int end) {
        if (begin < end) {
            int pivot = array[end];
            int temp;

            int j = begin;
            for (int i = begin; i < end; i++) {
                if (array[i] <= pivot) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                    System.out.println(Arrays.toString(array));
                    j++;
                }
            }

            temp = array[j];
            array[j] = pivot;
            array[end] = temp;

        
            sort(array, begin, j - 1);
            sort(array, j + 1, end);

        }
        return array;
    }
    
}
