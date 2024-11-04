package org.example.view;

import org.example.model.Calculator;

public class ConsoleCalculatorPrinter {
    private static ConsoleCalculatorPrinter instance;
    private static Calculator calculator;

    private ConsoleCalculatorPrinter() {
        calculator = Calculator.getInstance();
    }

    public static ConsoleCalculatorPrinter getInstance() {
        if (instance == null) {
            instance = new ConsoleCalculatorPrinter();
        }
        return instance;
    }

    public void print() {
        System.out.println(calculator);
    }
}
