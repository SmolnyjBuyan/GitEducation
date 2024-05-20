import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Task_01 {
    private static int LENGTH = 10000000;

    public static void main(String[] args) {
        getTime();
    }

    public static void getTime() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < LENGTH; i++) {
            arrayList.add(i);
        }

        long endTime = System.currentTimeMillis();

        double resultTime = endTime - startTime;

        System.out.printf("Run time for ArrayList: %s %s %n", resultTime, "ms");

        long startTime2 = System.currentTimeMillis();

        for (int i = 0; i < LENGTH; i++) {
            linkedList.add(i);
        }

        long endTime2 = System.currentTimeMillis();

        double resultTime2 = endTime2 - startTime2;

        System.out.printf("Run time for linkedList: %s %s %n", resultTime2, "ms");

        int count = 0;
        long startTime3 = System.currentTimeMillis();
        Random random = new Random();

        while (count != 1000) {
            linkedList.add(40000, random.nextInt());
            count++;
        }

        long endTime3 = System.currentTimeMillis();
        double resultTime3 = endTime3 - startTime3;

        System.out.printf("Run time for add operation: %s %s %n", resultTime3, "ms");

    }
}