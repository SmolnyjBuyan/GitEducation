package controllers;

import models.User;

public interface UserController {

    <T extends User> User create(T user);
}
