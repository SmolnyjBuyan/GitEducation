import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;
public class Task01 {
    public static void main(String[] args) {
        int[] toWrite = IntStream.range(0, 9).map(n -> (int)(Math.random() * 101)).toArray();

        System.out.println(Arrays.toString(toWrite));

        try(FileOutputStream fos = new FileOutputStream("task_01.txt")) {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append('[');
            int i;
            for (i = 0; i < toWrite.length - 1; i++) {
                stringBuilder.append(toWrite[i]).append(", ");
            }
            stringBuilder.append(toWrite[i]);
            stringBuilder.append(']');

            byte[] buffer = stringBuilder.toString().getBytes();
            fos.write(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}