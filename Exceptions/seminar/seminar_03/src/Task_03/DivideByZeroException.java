package Task_03;

public class DivideByZeroException extends ArithmeticException{
    public DivideByZeroException() {
        super("Делить на ноль нельзя");
    }
}
