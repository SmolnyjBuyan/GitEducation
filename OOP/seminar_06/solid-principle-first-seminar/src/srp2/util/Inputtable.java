package srp2.util;

import java.util.Scanner;

public interface Inputtable {
    default String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
