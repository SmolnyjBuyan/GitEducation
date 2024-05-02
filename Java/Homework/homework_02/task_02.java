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
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;


public class task_02 {
    public static void main(String[] args) {
        int[] array = new int[] { 9, 3, 4, 8, 2, 5, 7, 1, 6, 10 };
        BubbleSort.sort(array);
    }
}


class BubbleSort {
    private static File log;
    private static FileWriter fileWriter;
    
    public static void sort(int[] mas) {
        int temp;
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();
        log = new File("log.txt");

        try {
            fileWriter = new FileWriter(log, false);
            fileWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }



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
            try {
                fileWriter = new FileWriter(log, true);
                fileWriter.write(date + " " + time.truncatedTo(ChronoUnit.MINUTES) + " " + Arrays.toString(mas) + "\n");
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            if (isSorted) break;
        }
    }
}