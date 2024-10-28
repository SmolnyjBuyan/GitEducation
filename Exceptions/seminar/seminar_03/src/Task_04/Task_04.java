package Task_04;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.StringTemplate.STR;

public class Task_04 {
    public static void main(String[] args) {
        String[][] matrix = {{"23", "2", "67", "2"}, {"11", "3", "ы", "4"}, {"33", "12", "54", "1"}, {"32", "1", "67", "2"}};
        try {
            System.out.println(getSumOfElements(matrix));
        } catch (MyArraySizeException | MyArrayDataException e ) {
            System.out.println(e.getMessage());
        }
    }

    public static int getSumOfElements(String[][] matrix) throws MyArrayDataException, MyArraySizeException {
        if (matrix.length != 4 || IntStream.range(0, matrix.length).anyMatch(i -> matrix[i].length != 4)) {
            throw new MyArraySizeException();
        }

        int[][] intValues = new int[matrix.length][matrix[0].length];


        for (int i = 0; i < intValues.length; i++) {
            for (int j = 0; j < intValues[i].length; j++) {
                try {
                    intValues[i][j] = Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        for (int[] array : intValues) {
            System.out.println(Arrays.toString(array));
        }

        return Arrays.stream(intValues).flatMapToInt(Arrays::stream).reduce(0, Integer::sum);
    }
}
