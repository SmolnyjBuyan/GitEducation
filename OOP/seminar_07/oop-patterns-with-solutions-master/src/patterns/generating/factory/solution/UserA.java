package patterns.generating.factory.solution;

public class UserA implements Authorizable {
    private final String login;
    private final String password;

    public UserA() {
        this.login = prompt("Enter login: ");
        this.password = prompt("Enter password: ");
    }

    public Authorizable createUser() {
        System.err.println("You try to get access into production profile. Please, authorized");
        return new UserA();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
