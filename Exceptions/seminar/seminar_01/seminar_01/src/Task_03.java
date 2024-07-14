import java.util.Arrays;

public class Task_03 {
    public static void main(String[] args) {
        int [][] twoDimArray = {{1,0,1,1}, {1,0,1,1}, {0,1,0,1}, {0,1,0,1}};
        System.out.println(getSumOfElements(twoDimArray));
    }

    public static int getSumOfElements(int[][] twoDimArray) {
        boolean isPresent = Arrays.stream(twoDimArray).flatMapToInt(Arrays::stream).anyMatch(x -> x != 0 && x != 1);
        boolean isNotEven = Arrays.stream(twoDimArray).anyMatch(x -> x.length != twoDimArray.length);

        if (isNotEven || isPresent) {
            throw new RuntimeException("Массив не квадратный или его значения не равны 0 или 1");
        }

        return Arrays.stream(twoDimArray).flatMapToInt(Arrays::stream).sum();
    }
}
