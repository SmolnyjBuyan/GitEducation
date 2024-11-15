public class RowConvertException extends RuntimeException{
    public RowConvertException(int[] array, int index) {
        super(String.format
                ("array[%d].length must be equal to 5, but in your case it equals to %d", index, array.length));
    }
}
