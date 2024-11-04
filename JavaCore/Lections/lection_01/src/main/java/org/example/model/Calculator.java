package org.example.model;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private static Calculator instance;
    private static Map<Character, Calculable> operations;
    private double firstOperand;
    private double secondOperand;
    private char operation;
    private double result;

    public double getFirstOperand() {
        return firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

    public char getOperation() {
        return operation;
    }

    public double getResult() {
        return result;
    }

    private Calculator() {};

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
            operations = new HashMap<>();
            operations.put('+', (x, y) -> x + y);
            operations.put('-', (x, y) -> x - y);
            operations.put('*', (x, y) -> x * y);
            operations.put('/', (x, y) -> x / y);
        }
        return instance;
    }

    private void operate(double x, double y) {
        firstOperand = x;
        secondOperand = y;
        result = operations.get(operation).calculate(firstOperand, secondOperand);
    }

    public void sum(double summand, double addend) {
        operation = '+';
        operate(summand, addend);
    }

    public void diff(double minuend, double subtrahend) {
        operation = '-';
        operate(minuend, subtrahend);
    }

    public void multiply(double multiplicand, double multiplier) {
        operation = '*';
        operate(multiplicand, multiplier);
    }

    public void divide(double numerator, double denominator) {
        operation = '/';
        operate(numerator, denominator);
    }

    @Override
    public String toString() {
        return getFirstOperand() + " " +
                getOperation() + " " +
                getSecondOperand() + " = " +
                getResult();
    }

    @FunctionalInterface
    interface Calculable {
        double calculate(double x, double y);
    }
}
