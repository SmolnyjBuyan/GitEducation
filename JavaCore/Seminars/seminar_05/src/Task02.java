import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class Task02 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(createFromFile("task_01.txt")));
    }
    public static int[] createFromFile(String fileName){
        String[] toParse = getFromFile(fileName).split(", ");
        return Stream.of(toParse).mapToInt(Integer::parseInt).toArray();

    }

    public static String getFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try (FileInputStream fis = new FileInputStream(fileName)){
            byte[] buffer = new byte[256];

            int count;
            while ((count = fis.read(buffer)) != -1) {
                for (int i = 0; i < count; i++) {
                    stringBuilder.append((char)buffer[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stringBuilder.substring(1, stringBuilder.length() - 1);
    }
}
