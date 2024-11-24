import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task02 {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 2, 3, 2, 1, 1, 2};

        write(numbers);
    }

    public static void write(int[] array) {
        byte[] bytes = new byte[3];

        for (int i = 0; i < 3; i++) {
            byte temp = 0;
            for (int j = 0; j < 3; j++) {
                temp += (byte) (array[(3 * i) + j] << (j * 2));
            }
            bytes[i] = temp;

            Path path = Paths.get("task_02.txt");
            try {
                Files.write(path, bytes);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
