package service;

import model.User;

import java.util.List;

public interface UserService<T extends User> {
    T create(String name, String lastName);
    T getById(int id) throws Exception;
    List<T> getAll();
}
