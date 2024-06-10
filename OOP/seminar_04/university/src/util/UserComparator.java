package util;

import models.User;

import java.util.Comparator;

public class UserComparator<T extends User> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        int firstLength = (o1.getFirstname() + o1.getLastname()).length();
        int secondLength = (o2.getFirstname() + o2.getLastname()).length();
        return firstLength - secondLength;
    }
}
