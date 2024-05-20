import java.util.ArrayDeque;
import java.util.Deque;

public class Task_03 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int example = calculator.calculate('+', 5, 6);
        System.out.println(example);

        int example2 = calculator.calculate('-', 11, 2);
        System.out.println(example2);

        int example3 = calculator.calculate('*', 6, 6);
        System.out.println(example3);

        int example4 = calculator.calculate('<', 6, 6);
        System.out.println(example4);

        int example5 = calculator.calculate('<', 6, 6);
        System.out.println(example5);

        int example6 = calculator.calculate('<', 6, 6);
        System.out.println(example6);

        int example7 = calculator.calculate('<', 6, 6);
        System.out.println(example7);

        int example8 = calculator.calculate('<', 6, 6);
        System.out.println(example8);
        
        int example9 = calculator.calculate('*', 6, 6);
        System.out.println(example9);
    }
}

class Calculator {
    private Deque<Integer> operations = new ArrayDeque<>();

    public int calculate(char op, int a, int b) {
        switch (op) {
            case '+':
                operations.addFirst(a + b);
                return operations.peekFirst();
            case '-':
                operations.addFirst(a - b);
                return operations.peekFirst();
            case '*':
                operations.addFirst(a * b);
                return operations.peekFirst();
            case '<':
                if (isDequeNull()) {
                    throw new RuntimeException("История операций пустая");
                }
                operations.pollFirst();
                return operations.peekFirst();
            default:
                throw new RuntimeException("Такой операции нет в калькуляторе");
        }  
    }

    private boolean isDequeNull(){
        int temp = operations.pollFirst();
        boolean result = operations.peekFirst() == null;
        operations.addFirst(temp);
        return result;
    }
}
