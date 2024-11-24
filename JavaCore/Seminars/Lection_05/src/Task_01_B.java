import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Task_01_B {
    public static void main(String[] args) {

        int[] numbers = IntStream.range(0, 9).map(n -> (int) (Math.random() * 101)).toArray();
        System.out.println(Arrays.toString(numbers));
        int[] ar0 = {1,2,3,4,5,6,7,8,0,8,7,6,5,4,3};

        createArrayFile("task_01_b.txt", numbers);
    }

    public static void createArrayFile(String fileName, int[] array) {
        final int DIGIT_BOUND = 48;

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(9 + 48);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}