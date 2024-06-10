package util;

import models.Student;
import models.User;

import java.util.List;

public interface UserView<T extends User> {
    public void sendOnConsole(List<T> users) ;
}
