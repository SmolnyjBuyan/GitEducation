package view;

import java.util.Scanner;

public abstract class UserView {
    protected void start(String menu) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(menu);

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> create();
                case 2 -> getById();
                case 3 -> getAll();
                case 4 -> {
                    return;
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }
    protected abstract void create();
    protected abstract void getById();
    protected abstract void getAll();
}
