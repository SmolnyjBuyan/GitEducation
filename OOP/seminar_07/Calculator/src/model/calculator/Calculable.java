package model.calculator;

public interface Calculable<T extends Number> {
    T sum(T first, T second);

    T multiply(T first, T second);

    T divide(T first, T second);

    T subtraction(T first, T second);
}
