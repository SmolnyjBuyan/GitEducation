// Напишите метод, который вернет содержимое текущей папки в виде массива строк.
// Напишите метод, который запишет массив, возвращенный предыдущим методом в файл.
// Обработайте ошибки с помощью try-catch конструкции. В случае возникновения
// исключения, оно должно записаться в лог-файл.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class task_01 {

    private static Logger LOGGER = log.log(task_01.class.getName());
    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "Приложение стартовало");
        String out = "D:\\Study\\GitEducation\\Java\\Seminar\\seminar_02";
        System.out.println(String.join(";", readFileNamesInDir("D:\\Study\\GitEducation\\Java\\Seminar\\seminar_02")));

        writeFileNamesInFile("task_01.txt", out);

    }

    private static String[] readFileNamesInDir(String path) {
        File file = new File(path);

        if (file.isDirectory()) {
            if (isThrow()) {
                LOGGER.log(Level.SEVERE, "Возникла ошибка: метод чтения");
                throw new RuntimeException("Возникла ошибка: метод чтения");
            }
            File[] files = file.listFiles();
            String[] names = new String[files.length];
            
            for (int i = 0; i < files.length; i++) {
                names[i] = files[i].getName();
            }

            return names;
        } else {
            throw new RuntimeException("File is not a directory");
        }
    }

    private static void writeFileNamesInFile(String in, String out) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(in);
            if (isThrow()) {
                LOGGER.log(Level.SEVERE, "Возникла ошибка: метод записи");
                // throw new RuntimeException("Возникла ошибка: метод записи");
            }
            String[] arr = readFileNamesInDir(out);

            for (int i = 0; i < arr.length; i++) {
                fw.write(arr[i] + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                // throw new RuntimeException("Error closing file", e);
            }
        }
    }

    private static boolean isThrow() {
        int a = 0;
        int b = 2;
        int digit = a + (int) (Math.random() * b);
        System.out.println(digit);
        return digit > 0;
        }
}
