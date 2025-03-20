package com.mycompany.app;

/**
 * Hello world!
 *
 */
public final class App {
    /**
     * @param args default
     */
    public static void main(final String[] args) {
        System.out.println("Hello World!");
    }

    private App() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated");
    }
}
