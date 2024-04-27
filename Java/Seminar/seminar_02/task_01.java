import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class task_01 {
    public static void main(String[] args) {
        readFileNames("C:\\Users\\akotov\\Documents\\GitEducation");       
    }

    public static void readFileNames(String path) {
        FileReader reader = null;
        File file = new File(path);
        
        try {
            if (file.isDirectory()) {
                reader = new FileReader(file);
                File[] arrFiles = file.listFiles();
                System.out.println(arrFiles.toString());

            } else {
                throw new IOException("Файл не является папкой");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}