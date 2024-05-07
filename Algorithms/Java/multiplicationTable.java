import java.util.Arrays;

public class multiplicationTable {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 7, 8, 234};
        printTable(array);
    }

    private static void printTable(int[] array) {
        int[] multiplicationArray = new int[array.length];
        String format = "%-" + String.format("%s", getCellSize(array)) + "s";

        for (int i = 0; i < array.length; i++) {
            System.out.printf(format, array[i]); 
        }
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                multiplicationArray[j] = array[i] * array[j];
                System.out.printf(format, multiplicationArray[j]);
            }

            System.out.println();
        }
    }

    private static int getCellSize(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int length = (int) (Math.log10(max * max) + 1);
        return length;
    }
}
