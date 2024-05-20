import java.util.ArrayList;
import java.util.Arrays;

public class Task_02 {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(Answer.removeEvenNumbers(arr));
    }
}

class Answer {
    public static ArrayList<Integer> removeEvenNumbers(Integer[] arr) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }

        return list;
    }
}
