import java.util.Arrays;

public class Task_04 {
    public static void main(String[] args) {
        int [][] twoDimArray = {{1,0,1,1}, {1,0,1,1}, {0,1,0,1}, {0,1,0,}};
        int result = getSumOfElements(twoDimArray);

        if (result == -1) {
            System.out.println("Массив не квадратный или его значения не равны 0 или 1");
        } else {
            System.out.println(result);
        }
    }

    public static int getSumOfElements(int[][] twoDimArray) {
        boolean isPresent = Arrays.stream(twoDimArray).flatMapToInt(Arrays::stream).anyMatch(x -> x != 0 && x != 1);
        boolean isNotEven = Arrays.stream(twoDimArray).anyMatch(x -> x.length != twoDimArray.length);

        if (isNotEven || isPresent) {
            return -1;
        }

        return Arrays.stream(twoDimArray).flatMapToInt(Arrays::stream).sum();
    }
}
