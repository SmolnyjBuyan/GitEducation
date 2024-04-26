// В методе calculate класса Calculator реализовать калькулятор, который будет выполнять математические операции (+, -, *, /)
// над двумя целыми числами и возвращать результат вещественного типа.
// В классе Printer необходимо реализовать проверку переданного оператора, при некорректном операторе
// программа должна вывести сообщение об ошибке "Некорректный оператор: 'оператор'".

public class task_03 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double result = calculator.calculate('=', 2, 3);
        System.out.println(result);
    }
}

class Calculator {
    public int calculate(char op, int a, int b) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else if (op == '/') {
            return (a / b);
        } else {
            throw new RuntimeException("Некорректный оператор: 'оператор'");
        }
    }
}