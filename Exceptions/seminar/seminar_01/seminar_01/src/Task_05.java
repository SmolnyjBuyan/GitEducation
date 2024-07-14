import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task_05 {
    public static void main(String[] args) {
        Integer[] array = {1, 0, 2, 0, 3};
        checkArray2(array);
    }

    public static void checkArray(Integer[] arr) {
        IntStream.range(0, arr.length).filter(i -> arr[i] == null).
                forEach(i -> System.out.println("Index " + i + " = null"));
    }

    public static void checkArray2(Integer[] arr) {
        if (IntStream.range(0, arr.length).filter(i -> arr[i] == null).findAny().isEmpty()) {
            System.out.println("Элементов со значением null не найдено");
        } else {
            IntStream.range(0, arr.length).filter(i -> arr[i] == null).
                    forEach(i -> System.out.println("Index " + i + " = null"));
        }
    }
}
