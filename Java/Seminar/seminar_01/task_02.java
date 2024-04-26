// В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида
// "Доброе утро, <Имя>!", если время от 05:00 до 11:59
// "Добрый день, <Имя>!", если время от 12:00 до 17:59;

import java.time.LocalTime;
import java.util.Scanner;

public class task_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String time = String.valueOf(LocalTime.now());
        String name;

        System.out.println("Введите имя пользователя: ");
        name = scanner.nextLine();
       
        System.out.println(time);
        
        String[] hourMinSec = time.split(":");
        
        int hour = Integer.parseInt(hourMinSec[0]);
        int min = Integer.parseInt(hourMinSec[1]);

        System.out.println("Часы: " + hour);
        System.out.println("Минуты: "+ min);

        if (hour >= 5 && hour < 12) {
            System.out.println("Доброе утро, " + name + "!");
        } else if (hour >= 12 && hour < 18) {
            System.out.println("Добрый день, " + name + "!");
        }

        scanner.close();
    }
}
