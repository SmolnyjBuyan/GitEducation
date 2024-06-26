package model.calculator;

import model.number.ComplexNumber;

public class ComplexNumberCalculator implements Calculable<ComplexNumber> {

    public ComplexNumber sum(ComplexNumber first, ComplexNumber second) {
        return new ComplexNumber(first.getRealPart() + second.getRealPart(),
                first.getImaginaryPart() + second.getImaginaryPart());
    }

    public ComplexNumber subtraction(ComplexNumber first, ComplexNumber second) {
        return new ComplexNumber(first.getRealPart() - second.getRealPart(),
                first.getImaginaryPart() - second.getImaginaryPart());
    }

    public ComplexNumber multiply(ComplexNumber first, ComplexNumber second) {
        return new ComplexNumber(first.getRealPart() * second.getRealPart() -
                first.getImaginaryPart() * second.getImaginaryPart(),
                first.getImaginaryPart() * second.getRealPart() +
                        first.getRealPart() * second.getImaginaryPart());
    }

    public ComplexNumber divide(ComplexNumber first, ComplexNumber second) {
        try {
            ComplexNumber conjugateNumber = new ComplexNumber(second.getRealPart(), -second.getImaginaryPart());
            ComplexNumber numerator = multiply(first, conjugateNumber);
            double denominator = Math.pow(second.getRealPart(), 2) + Math.pow(second.getImaginaryPart(), 2);

            return new ComplexNumber(numerator.getRealPart() / denominator,
                    numerator.getImaginaryPart() / denominator);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("На ноль делить нельзя!");
        }
    }

}
