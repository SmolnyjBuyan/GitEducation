package patterns.behavioral.strategy.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Run {
    private final static Map<String, Calculable> operations = new HashMap<>();

    static {
        operations.put("+", args -> args[0] + args[1]);
        operations.put("-", args -> args[0] - args[1]);
        operations.put("*", args -> args[0] * args[1]);
        operations.put("/", args -> args[0] / args[1]);
    }

    public static void main(String[] args) {
        System.out.println(calculate());
    }

    private static double calculate() {
        double operand1 = Double.parseDouble(prompt("Enter first number: "));
        String operator = prompt("Enter math operation (+ / - *): ");
        double operand2 = Double.parseDouble(prompt("Enter second number: "));

        if (operations.containsKey(operator))
            return operations.get(operator).calculate(operand1, operand2);
        else
            throw new RuntimeException("Unsupported math operation");
    }

    private static String prompt(String message) {
        System.out.println(message);
        return new Scanner(System.in).next();
    }
}

interface Calculable{
    double calculate(double ... args);
}
