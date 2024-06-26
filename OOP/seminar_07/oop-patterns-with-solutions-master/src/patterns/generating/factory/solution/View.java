package patterns.generating.factory.solution;

public class View implements AbstractFabric {
    private final String property;
    private Authorizable authorizable;

    public View() {
        this.property = AppProperty.load();
        createUser();
    }

    @Override
    public Authorizable createUser() {
        if (property.equalsIgnoreCase("dev")) {
            this.authorizable = new UserU();
        }
        if (property.equalsIgnoreCase("prod")) {
            UserA a = new UserA();
            if (DB.contains(a)) {
                this.authorizable = a;
            } else throw new RuntimeException("Wrong login or password");
        }
        System.err.println("You registered successfully");
        return authorizable;
    }
}
