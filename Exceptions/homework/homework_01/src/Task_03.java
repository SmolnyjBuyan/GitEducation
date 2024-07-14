import java.util.Arrays;

public class Task_03 {
    public static void main(String[] args) {
        int[] a = new int[]{12, 8, 16};
        int[] b = new int[]{4, 2, 4};

        System.out.println(Arrays.toString(divArrays(a, b)));
    }

    public static int[] divArrays(int[] a, int[] b) {
        try {
            if (a.length != b.length) return new int[]{0};
            int[] result = new int[a.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = a[i] / b[i];
            }
            return result;
        } catch (RuntimeException e) {
            throw new RuntimeException();
        }
    }
}
