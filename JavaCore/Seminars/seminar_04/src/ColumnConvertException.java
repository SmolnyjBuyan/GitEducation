public class ColumnConvertException extends RuntimeException{
    public ColumnConvertException(int[][] array) {
        super("array.length must be equal to 5, but in your case it equals to " + array.length);
    }
}
