package patterns.generating.factory.solution;

import java.util.Scanner;

public interface Authorizable {
    default String prompt(String message) {
        System.out.println(message);
        return new Scanner(System.in).next();
    }
}
