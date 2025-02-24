package org.example;

import java.util.HashMap;

public class DataBase {
    private HashMap<String, String> users;

    public DataBase() {
        users = new HashMap<>();
        users.put("Andrey", "123456");
        users.put("Sergey", "1234");
        users.put("Dmitry", "1234");
        users.put("Ilya", "1234567");
    }

    public boolean isUserValid(String username, String password) {
        if (!users.containsKey(username)) return false;
        return users.get(username).equals(password);
    }
}
