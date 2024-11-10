import java.util.Arrays;
import java.util.IntSummaryStatistics;


public class Task02 {
    public static void main(String[] args) {
        int[] sample01 = {2, 1, 2, 3, 4};
        int[] sample02 = {-19, -10};
        int[] sample03 = new int[3];

        System.out.println(Arrays.toString(sample01) + " -> " + getDifferenceMinMax(sample01));
        System.out.println(Arrays.toString(sample02) + " -> " + getDifferenceMinMax(sample02));
        System.out.println(Arrays.toString(sample03) + " -> " + getDifferenceMinMax(sample03));
    }

    public static int getDifferenceMinMax(int[] array) {
        IntSummaryStatistics stat = Arrays.stream(array).summaryStatistics();
        return stat.getMax() - stat.getMin();
    }
}
