package controller;

import model.User;

import java.util.List;

public interface UserController<T extends User>{
    T create(String name, String lastName);
    T getById(int id);
    List<T> getAll();
}
