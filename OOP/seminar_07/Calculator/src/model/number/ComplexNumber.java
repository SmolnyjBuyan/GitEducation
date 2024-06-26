package model.number;

import java.text.DecimalFormat;

public class ComplexNumber extends Number {
    private double realPart;
    private double imaginaryPart;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("+#.###;-#.###");
        DecimalFormat startFormat = new DecimalFormat("#.###");
        return startFormat.format(realPart) + format.format(imaginaryPart) + 'i';
    }

    @Override
    public int intValue() {
        return (int) realPart;
    }

    @Override
    public long longValue() {
        return (long) realPart;
    }

    @Override
    public float floatValue() {
        return (float) realPart;
    }

    @Override
    public double doubleValue() {
        return realPart;
    }
}
