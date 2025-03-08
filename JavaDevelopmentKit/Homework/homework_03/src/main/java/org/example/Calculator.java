package org.example;

public class Calculator {
    public static <T extends Number> double sum(T summand, T addend) {
        return summand.doubleValue() + addend.doubleValue();
    }

    public static <T extends Number> double multiply(T multiplicanda, T multiplier) {
        return multiplicanda.doubleValue() * multiplier.doubleValue();
    }

    public static <T extends Number> double divide(T dividend, T divisor) {
        return dividend.doubleValue() / divisor.doubleValue();
    }

    public static <T extends Number> double subtract(T minuend, T subtrahend) {
        return minuend.doubleValue() - subtrahend.doubleValue();
    }
}
