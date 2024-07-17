import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Task_01 {
    public static void main(String[] args) {
        try {
            doSomething();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void doSomething() throws FileNotFoundException {
        FileReader fileReader = new FileReader("Test");
    }
}
