package homework;

public class UserManager {
    private final User user;

    public UserManager(User user){
        this.user = user;
    }

    public void save(){
        System.out.println("Save user: " + user.getName());
    }

    public void report(){
        System.out.println("Report for user: " + user.getName());
    }
}
