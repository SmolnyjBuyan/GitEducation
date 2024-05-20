import java.util.Arrays;

public class Task_01 {

    public static void main(String[] args) {
        int[] array = new int[]{5, 1, 6, 2, 3, 4};

        MergeSort.mergeSort(array);
    }
}


class MergeSort {
    public static int[] mergeSort(int[] a) {
        if (a.length < 2) {
            return a;
        }
        
        int[] leftHalf = new int[(int) Math.ceil((double) a.length / 2)];
        for (int i = 0; i < leftHalf.length; i++) {
            leftHalf[i] = a[i];
        }
        leftHalf = mergeSort(leftHalf);

        int[] rightHalf = new int[a.length / 2];
        for (int i = 0; i < rightHalf.length; i++) {
            rightHalf[i] = a[i + leftHalf.length];
        }
        rightHalf = mergeSort(rightHalf);

        int[] mergedHalves = new int[a.length];

        int j = 0;
        int k = 0;
        for (int i = 0; i < mergedHalves.length; i++) {
            if (j == leftHalf.length) {
                mergedHalves[i] = rightHalf[k];
                k++;
            } else if (k == rightHalf.length) {
                mergedHalves[i] = leftHalf[j];
                j++;
            } else if (leftHalf[j] < rightHalf[k]) {
                mergedHalves[i] = leftHalf[j];
                j++;
            } else {
                mergedHalves[i] = rightHalf[k];
                k++;
            }   
        }

        System.out.println(Arrays.toString(mergedHalves));
        return mergedHalves;
    }
}