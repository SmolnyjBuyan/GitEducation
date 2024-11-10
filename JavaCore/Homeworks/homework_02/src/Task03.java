import java.util.Arrays;

public class Task03 {
    public static void main(String[] args) {
        int[] sample01 = {2, 1, 2, 3, 4};
        int[] sample02 = {0, 1, 0, 0, 1};
        int[] sample03 = {0, 1, 0, 1, 0};
        int[] sample04 = new int[3];

        System.out.println(Arrays.toString(sample01) + " -> " + isThereZeroNeighbours(sample01));
        System.out.println(Arrays.toString(sample02) + " -> " + isThereZeroNeighbours(sample02));
        System.out.println(Arrays.toString(sample03) + " -> " + isThereZeroNeighbours(sample03));
        System.out.println(Arrays.toString(sample04) + " -> " + isThereZeroNeighbours(sample04));
    }

    public static boolean isThereZeroNeighbours(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 0 && array[i - 1] == 0) return true;
        }
        return false;
    }
}
