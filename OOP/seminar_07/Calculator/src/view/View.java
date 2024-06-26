package view;

import model.calculator.LoggedComplexNumberCalculator;
import model.logger.FileLogger;
import model.number.ComplexNumber;
import util.Operators;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class View {
    private final List<String> validOperators;
    LoggedComplexNumberCalculator calculator = new LoggedComplexNumberCalculator();
    FileLogger fileLogger = new FileLogger();

    public View() {
        this.validOperators = Arrays.stream(Operators.values()).map(Operators::operator).collect(Collectors.toList());
    }

    public void start() {
        fileLogger.log("Запуск приложения");

        while (true) {
            double firstRealPart = promptDouble("Введите действительную часть первого комплексного числа: ");
            double firstImaginaryPart = promptDouble("Введите мнимую часть первого комплексного числа: ");
            ComplexNumber first = new ComplexNumber(firstRealPart, firstImaginaryPart);
            System.out.println("Первое комплексное число: " + first);

            double secondRealPart = promptDouble("Введите действительную часть второго комплексного числа: ");
            double secondImaginaryPart = promptDouble("Введите мнимую часть второго комплексного числа: ");
            ComplexNumber second = new ComplexNumber(secondRealPart, secondImaginaryPart);
            System.out.println("Первое комплексное число: " + second);

            String operator = getOperator();
            switch (operator) {
                case "+" -> System.out.printf("(%s) %s (%s) = %s%n",
                        first, operator, second, calculator.sum(first, second));
                case "-" -> System.out.printf("(%s) %s (%s) = %s%n",
                        first, operator, second, calculator.subtraction(first, second));
                case "/" -> System.out.printf("(%s) %s (%s) = %s%n",
                        first, operator, second, calculator.divide(first, second));
                case "*" -> System.out.printf("(%s) %s (%s) = %s%n",
                        first, operator, second, calculator.multiply(first, second));
            }

            if (!isExit()) {
                fileLogger.log("Корректное завершение приложения");
                System.exit(0);
            }
        }
    }

    private String getOperator() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите необходимую математическую операцию (*, +, /, -) : ");
        String operator = in.nextLine();
        while (true) {
            if (isInvalidOperator(operator)) {
                System.err.println("Введена неверная математическая операция "
                        + "Введите необходимую математическую операцию (*, +, /, -) : ");
                operator = in.nextLine();
            } else return operator;
        }
    }

    private boolean isInvalidOperator(String operator) {
        return !validOperators.contains(operator);
    }

    private double promptDouble(String message) {
        Scanner in = new Scanner(System.in);
        double result = 0;

        System.out.println(message);
        try {
            result = Double.parseDouble(in.nextLine());
        } catch (NumberFormatException e) {
            fileLogger.log(e.toString());
            System.err.println("Формат ввода числа неверный!");
            promptDouble(message);
        }
        fileLogger.log("Пользователь ввел '" + result + "' с клавиатуры");
        return result;
    }

    private boolean isExit() {
        Scanner in = new Scanner(System.in);
        int choice = 0;

        System.out.println("1 - Продолжить, 0 - Выход");

        try {
            choice = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            fileLogger.log(e.toString());
            System.err.println("Неверный формат ввода!");
            isExit();
        }
        return choice == 1;
    }
}
