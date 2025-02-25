package org.example;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBase {
    private final List<User> users;

    public DataBase() {
        users = new ArrayList<>();
        users.add(new User("Andrey", "123456"));
        users.add(new User("Sergey", "1234"));
        users.add(new User("Dmitry", "1234"));
        users.add(new User("Ilya", "1234567"));
    }

    public boolean isUserValid(String username, String password) {
        User userToLogin = new User(username, password);
        int userToLoginIndex = users.indexOf(userToLogin);
        if (userToLoginIndex == -1) return false;
        return users.get(userToLoginIndex).isValid(password);
    }
}
