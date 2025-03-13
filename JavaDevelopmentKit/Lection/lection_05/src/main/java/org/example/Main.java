package org.example;

public class Main {
    public static void main(String[] args) {
        Thread tic = new Thread(new TicTakToe());
        Thread tac = new Thread(new TicTakToe());
        Thread toe = new Thread(new TicTakToe());
        tic.start();
        tac.start();
        toe.start();
    }
}