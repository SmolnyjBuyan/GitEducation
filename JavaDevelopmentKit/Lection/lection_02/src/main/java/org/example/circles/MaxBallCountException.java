package org.example.circles;

public class MaxBallCountException extends RuntimeException {
    public MaxBallCountException() {
        super("The maximum number of balls has been reached!");
    }
}
