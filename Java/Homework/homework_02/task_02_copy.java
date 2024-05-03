// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

// Напишите свой код в методе sort класса BubbleSort. Метод sort принимает на вход один параметр:

// int[] arr - числовой массив

// После каждого прохода по массиву ваш код должен делать запись в лог-файл 'log.txt' в формате год-месяц-день час:минуты {массив на данной итерации}.
// Для логирования использовать логгер logger класса BubbleSort.

// Пример
// arr = new int[]{9, 4, 8, 3, 1};
// sort(arr)

// // При чтении лог-файла получим:
// 2023-05-19 07:53 [4, 8, 3, 1, 9]
// 2023-05-19 07:53 [4, 3, 1, 8, 9]
// 2023-05-19 07:53 [3, 1, 4, 8, 9]
// 2023-05-19 07:53 [1, 3, 4, 8, 9]
// 2023-05-19 07:53 [1, 3, 4, 8, 9]

import java.io.File;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class task_02_copy {
    public static void main(String[] args) throws IOException {
        int[] array = new int[] { 9, 3, 4, 8, 2, 5, 7, 1, 6, 10 };
        BubbleSort.sort(array);
    }
}


class BubbleSort  {

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tR %5$s%6$s%n");
    }

    private static File log;
    private static FileWriter fileWriter;
    
    public static void sort(int[] mas) throws IOException {
        int temp;
        Logger logger = initializeLogger();

        for (int i = 0; i < mas.length; i++) {
            boolean isSorted = true;

            for (int j = 0; j < mas.length - i - 1; j++) {
                if (mas[j] > mas[j+1]) {
                    isSorted = false;
                    temp = mas[j+1];
                    mas[j+1] = mas[j];
                    mas[j] = temp;
                }
            }
            logger.info(Arrays.toString(mas) + " ");
            // System.out.println(Arrays.toString(mas) + " " + i);
            if (isSorted) break;
        }
    }

    public static Logger initializeLogger() throws IOException {
        Logger logger = Logger.getLogger(BubbleSort.class.getName());
        // ConsoleHandler ch = new ConsoleHandler();
        FileHandler fh;
        try {
            fh = new FileHandler("ItsLogTime.txt", false);
            logger.addHandler(fh);
            fh.setFormatter(new SimpleFormatter());
            logger.setUseParentHandlers(false);
            return logger;
        } catch (SecurityException e) {
            throw new SecurityException("Что то не так, скорее политика безопасности");
        } catch (IOException e) {
            throw new IOException("Что то не так, нет доступа");
        }
    }
}

