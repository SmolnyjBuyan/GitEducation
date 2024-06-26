package model.calculator;

import model.logger.FileLogger;
import model.number.ComplexNumber;

public class LoggedComplexNumberCalculator implements Calculable<ComplexNumber> {
    Calculable<ComplexNumber> calculator = new ComplexNumberCalculator();
    FileLogger fileLogger = new FileLogger();

    @Override
    public ComplexNumber sum(ComplexNumber first, ComplexNumber second) {
        ComplexNumber result = calculator.sum(first, second);
        fileLogger.log(String.format("Проведено вычисление: (%s) + (%s) = %s%n", first, second, result));
        return result;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber first, ComplexNumber second) {
        ComplexNumber result = calculator.multiply(first, second);
        fileLogger.log(String.format("Проведено вычисление: (%s) * (%s) = %s%n", first, second, result));
        return result;
    }

    @Override
    public ComplexNumber divide(ComplexNumber first, ComplexNumber second) {
        ComplexNumber result = calculator.divide(first, second);
        fileLogger.log(String.format("Проведено вычисление: (%s) / (%s) = %s%n", first, second, result));
        return result;
    }

    @Override
    public ComplexNumber subtraction(ComplexNumber first, ComplexNumber second) {
        ComplexNumber result = calculator.subtraction(first, second);
        fileLogger.log(String.format("Проведено вычисление: (%s) - (%s) = %s%n", first, second, result));
        return result;
    }
}
