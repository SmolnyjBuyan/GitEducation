package org.example;

import org.example.model.Calculator;
import org.example.view.ConsoleCalculatorPrinter;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = Calculator.getInstance();
        calculator.sum(2, 3);

        ConsoleCalculatorPrinter consoleCalculatorPrinter = ConsoleCalculatorPrinter.getInstance();
        consoleCalculatorPrinter.print();

        calculator.diff(10, 9);
        consoleCalculatorPrinter.print();

        calculator.divide(9, 3);
        consoleCalculatorPrinter.print();

        calculator.multiply(8, 9);
        consoleCalculatorPrinter.print();
    }
}