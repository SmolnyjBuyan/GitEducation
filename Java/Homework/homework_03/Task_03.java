import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Task_03 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{-2, -1, 0, 1, 2, 3, 4, 5};

        Answer.analyzeNumbers(arr);
    }
}

class Answer {
    public static void analyzeNumbers(Integer[] arr) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));

        list.sort(null);
        System.out.println(list);
        System.out.println("Minimum is " + Collections.min(list));
        System.out.println("Maximum is " + Collections.max(list));

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        System.out.println(sum);

        double average = (double)sum / list.size();

        System.out.println("Average is = " + average);
    }
}