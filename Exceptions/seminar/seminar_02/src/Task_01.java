import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Укажите индекс элемента массива, в который хотите записать значение 1");
        try {
            int index = scanner.nextInt();
            arr[index] = 1;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Указан индекс за пределами массива");
        } catch (InputMismatchException e) {
            System.out.println("Формат ввода числа неверный");
        }
        System.out.println(Arrays.toString(arr));
    }
}
