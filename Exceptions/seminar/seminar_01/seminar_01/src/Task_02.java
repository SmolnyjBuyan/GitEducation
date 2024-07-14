import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Task_02 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 6, 8, 567, 97};
        prompt(array, 2);

    }

    public static void prompt(int[] array, int minLength) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");

        int value = scanner.nextInt();
        int index = getIndexByValue(array, value, minLength);
        switch (index) {
            case -1 -> System.out.println("Массив меньше минимальной длины");
            case -2 -> System.out.println("Элемента с таким значением в массиве нет");
            default -> System.out.printf("Значению %s соответствует index=%s%n", value, index);
        }
    }

    public static int getIndexByValue(int[] array, int value, int minLength) {
        if (array.length < minLength) return - 1;

        return IntStream.range(0, array.length).filter(i -> array[i] == value).findFirst().orElse(-2);
    }
}
