public class Task_01 {
    public static void main(String[] args) {
        numberFormatException();
    }

    public static void arrayOutOfBoundsException() {
        throw new ArrayIndexOutOfBoundsException();
    }

    public static void divisionByZero() {
        throw new ArithmeticException();
    }

    public static void numberFormatException() {
        throw new NumberFormatException();
    }
}
