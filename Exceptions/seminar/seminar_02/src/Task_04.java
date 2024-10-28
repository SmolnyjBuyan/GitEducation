import java.io.*;

public class Task_04 {
    public static void main(String[] args) {
        InputStream inputStream;
        try {
            String[] strings = {"asdf", "asdf"};
            String strings1 = strings[2];
            test();
            int a = 1 / 0;
            inputStream = new FileInputStream("sdafgdsaf");
            inputStream.close();
        } catch (IndexOutOfBoundsException | ArithmeticException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Я все равно выполнился");
        }
        System.out.println("Я жив");
    }

    public static void test() throws IOException {
        File file = new File("1");
        file.createNewFile();
        FileReader reader = new FileReader(file);
        reader.read();
        reader.close();
    }
}
