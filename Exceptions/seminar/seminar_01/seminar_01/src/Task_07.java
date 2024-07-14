import java.util.Arrays;

public class Task_07 {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 6, 8};
        int[] array2 = {1, 8, 9, 0};
        int[] array3 = {1, 8, 9};
        try {
            System.out.println(Arrays.toString(getArrayOfSummedElements(array1, array3)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int[] getArrayOfSummedElements(int[] firstArray, int[] secondArray) throws IllegalArgumentException{
        if (firstArray.length != secondArray.length) {
            throw new IllegalArgumentException("Длины массивов не равны");
        } else {
            int[] result = new int[firstArray.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = firstArray[i] + secondArray[i];
            }
            return result;
        }
    }
}
