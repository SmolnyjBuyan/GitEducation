import java.util.Arrays;

public class CrossArray {
    int[][] array;

    public CrossArray(int arraySize) {
        if (arraySize < 0) {
            arraySize = 0;
        }
        populate(arraySize);
    }

    private void populate(int arraySize){
        array = new int[arraySize][arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i][i] = 1;
            array[i][arraySize - 1 - i] = 1;
        }
    }

    public void print() {
        Arrays.stream(array).forEach(s -> System.out.println(Arrays.toString(s)));
    }
}
