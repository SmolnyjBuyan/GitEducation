import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter the login: ");
                String login = scanner.nextLine();
                System.out.print("Enter the password: ");
                String password = scanner.nextLine();
                System.out.print("Confirm the password: ");
                String confirmPassword = scanner.nextLine();

                if (register(login, password, confirmPassword)) {
                    System.out.println("Registration is complete");
                    break;
                } else {
                    System.out.println("You entered two different passwords");
                }
            } catch (WrongLoginException | WrongPasswordException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static boolean register(String login, String password, String confirmPassword) {
        if (login.length() >= 20) throw new WrongLoginException("The length of login must be lesser than 20");
        if (password.length() >= 20) throw new WrongPasswordException("The length of password must be lesser than 20");
        return password.equals(confirmPassword);
    }
}
