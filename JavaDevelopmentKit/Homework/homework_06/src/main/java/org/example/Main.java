package org.example;


import java.util.HashMap;
import java.util.Map;
import org.apache.commons.math3.stat.Frequency;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Boolean> results = new HashMap<>();
        Frequency frequency = new Frequency();

        for (int i = 0; i < 1000; i++) {
            boolean result = new MontyHallGame().isWin();
            results.put(i, result);
            frequency.addValue(result);
        }

        double winRate = frequency.getPct(true) * 100;
        System.out.printf("Процент побед: %.1f%%" + System.lineSeparator(),winRate);
        double loseRate = frequency.getPct(false) * 100;
        System.out.printf("Процент поражений: %.1f%%" + System.lineSeparator(),loseRate);
    }
}