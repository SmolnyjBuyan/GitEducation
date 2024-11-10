import java.util.Arrays;

public class Task01 {

    public static void main(String[] args) {
        int[] sample01 = {2, 1, 2, 3, 4};
        int[] sample02 = {2, 2, 0};
        int[] sample03 = {1, 3, 5};

        System.out.println(Arrays.toString(sample01) + " -> " + countEvens(sample01));
        System.out.println(Arrays.toString(sample02) + " -> " + countEvens(sample02));
        System.out.println(Arrays.toString(sample03) + " -> " + countEvens(sample03));
    }

    public static int countEvens(int[] array) {
        return (int) Arrays.stream(array).filter(n -> n % 2 == 0).count();
    }
}
