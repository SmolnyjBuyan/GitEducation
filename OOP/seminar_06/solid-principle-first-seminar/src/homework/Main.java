package homework;

public class Main{
    public static void main(String[] args){
        User user = new User("Bob");
        UserManager userManager = new UserManager(user);
        userManager.save();
        userManager.report();
    }
}