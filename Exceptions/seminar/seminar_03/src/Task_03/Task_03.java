package Task_03;

public class Task_03 {
    public static void main(String[] args) {

        int a = 9;
        int b = 0;


        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            if (b == 0) {
                throw new DivideByZeroException();
            }
            throw new ArithmeticException();
        }
    }
}
