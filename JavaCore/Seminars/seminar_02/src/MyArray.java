import java.util.Arrays;

public class MyArray {
    int[] array;

    public MyArray(int[] array) {
        this.array = array;
    }

    public void add(int value){
        int[] newArray = new int[array.length + 1];

        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[newArray.length - 1] = value;

        array = newArray;
    }

    public void add(int pos, int value) {
        if (isValid(pos)) {
            int[] newArray = new int[array.length + 1];

            System.arraycopy(array, 0, newArray, 0, pos);
            newArray[pos] = value;
            System.arraycopy(array, pos + 1 - 1, newArray, pos + 1, newArray.length - (pos + 1));

            array = newArray;
        } else {
            System.out.println("A position value is out of bounds");
        }
    }

    private boolean isValid(int pos) {
        return pos >= 0 && pos <= array.length;
    }

    public void print(){
        System.out.println(Arrays.toString(array));
    }
}
