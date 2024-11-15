import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 5, 7, 5 },
                { 3, 4, 6 , 7, 7 },
                { 3, 4, 6 , 7, 7 },
                { 3, 4, 6 , 7, 7 },
                { 3, 4, 6 , 7 }};

        System.out.println(sumOfComponents(arr));
    }

    public static int sumOfComponents(int[][] array) {
        int sum = 0;

        if (array.length != 5) {
            throw new ColumnConvertException
                    ("array.length must be equal to 5, but in your case it equals to " + array.length);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 5)  {
                throw new RowConvertException
                        ("array[" + i + "].length must be equal to 5, but in your case it equals to " + array[i].length);
            }
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }

        return sum;
    }
}