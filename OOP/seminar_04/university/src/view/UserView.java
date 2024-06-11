package view;

import models.User;

import java.util.List;

public interface UserView<T extends User> {
    void sendOnConsole(List<T> users) ;
}
