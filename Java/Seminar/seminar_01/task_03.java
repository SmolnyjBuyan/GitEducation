// Во фразе "Добро пожаловать на курс по Java" переставить слова в обратном порядке.

/**
 * task_03
 */
public class task_03 {

    public static void main(String[] args) {
        String greeting = "Добро пожаловать на курс по Java";
        String[] words = greeting.split(" ");
        String[] reverse = new String[words.length];

        for (int i = 0; i < reverse.length; i++) {
            reverse[reverse.length - i - 1] = words[i];
        }

        System.out.println(String.join(" ", reverse));
    }
}