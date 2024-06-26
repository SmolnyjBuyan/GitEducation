package patterns.generating.factory.solution;

public class UserU implements Authorizable {
    private String login;

    public UserU() {
        this.login = prompt("Enter login: ");
    }
}
