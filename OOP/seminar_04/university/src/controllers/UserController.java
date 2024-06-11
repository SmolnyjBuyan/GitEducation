package controllers;

import models.User;

public interface UserController<T extends User> {

    T create(String lastName, String firstName, String fatherName);
}
