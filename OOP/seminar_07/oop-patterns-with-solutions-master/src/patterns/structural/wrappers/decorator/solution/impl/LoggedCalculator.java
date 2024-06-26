package patterns.structural.wrappers.decorator.solution.impl;

import patterns.structural.wrappers.decorator.solution.Loggable;
import patterns.structural.wrappers.decorator.task.Calculable;

public class LoggedCalculator implements Calculable {
    private final Calculable calculable;
    private final Loggable logger;

    public LoggedCalculator(Calculable calculable, Loggable logger) {
        this.calculable = calculable;
        this.logger = logger;
    }

    @Override
    public void sum(double a, double b) {
        logger.log(String.format("Sum up %s and %s", a, b));
        calculable.sum(a, b);
    }

    @Override
    public void multiply(double a, double b) {
        logger.log(String.format("Multiply %s and %s", a, b));
        calculable.multiply(a, b);
    }

    @Override
    public void divide(double a, double b) {
        logger.log(String.format("Divide %s and %s", a, b));
        calculable.divide(a, b);
    }

    @Override
    public void subtraction(double a, double b) {
        logger.log(String.format("Subtract  %s from %s", b, a));
        calculable.subtraction(a, b);
    }

    @Override
    public double result() {
        double result = calculable.result();
        logger.log(String.format("Result: %s", result));
        return result;
    }

    @Override
    public void clear() {
        calculable.clear();
    }
}
