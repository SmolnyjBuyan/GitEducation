package org.example;


import lombok.Getter;

import java.util.Random;

public class MontyHallGame {
    private final int NUMBER_OF_DOORS = 3;
    private Random random;
    private boolean[] doors;
    @Getter
    private int answerIndex;

    public MontyHallGame() {
        init();
    }

    private void init() {
        random = new Random();
        int autoIndex = random.nextInt(NUMBER_OF_DOORS);
        doors = new boolean[NUMBER_OF_DOORS];
        doors[autoIndex] = true;
        answerIndex = getAnswer();
    }

    private int getAnswer() {
        int firstPickedDoorIndex = random.nextInt(NUMBER_OF_DOORS);
        int[] remainIndexes = getRemainIndexes(firstPickedDoorIndex);
        if (doors[firstPickedDoorIndex]) {
            return remainIndexes[random.nextInt(remainIndexes.length)];
        } else {
            for (int remainIndex : remainIndexes) {
                if (doors[remainIndex]) return remainIndex;
            }
        }
        throw new RuntimeException("Invalid boolean[] doors field");
    }

    private int[] getRemainIndexes(int pickedIndex) {
        int[] remainIndexes = new int[NUMBER_OF_DOORS - 1];
        int i = 0;
        while (i < pickedIndex) {
            remainIndexes[i] = i++;
        }
        while (i < remainIndexes.length) {
            remainIndexes[i] = ++i;
        }
        return remainIndexes;
    }

    public boolean isWin() {
        return doors[answerIndex];
    }

    public void printDoors() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < NUMBER_OF_DOORS - 1; i++) {
            if (!doors[i]) stringBuilder.append("goat, ");
            else stringBuilder.append("auto, ");
        }
        if (!doors[NUMBER_OF_DOORS - 1]) {
            stringBuilder.append("goat]");
        } else {
            stringBuilder.append("auto]");
        }
        System.out.println(stringBuilder);
    }
}
