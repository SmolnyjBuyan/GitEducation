import java.util.Arrays;

public class Task_02 {
    public static void main(String[] args) {
        int[] a = new int[]{4, 5, 6};
        int[] b = new int[]{1, 2, 3};

        System.out.println(Arrays.toString(subArrays(a, b)));
    }

    public static int[] subArrays(int[] a, int[] b){
        if (a.length != b.length) return new int[]{0};

        int[] result = new int[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = a[i] - b[i];
        }
        return result;
    }
}
