package models;

import util.UserComparator;

public abstract class User implements Comparable<User>{
    protected int id;
    protected String firstname;
    protected String lastname;
    protected String surname;

    @Override
    public String toString() {
        return id + ". " + lastname + " " + firstname + " " + surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int compareTo(User o) {
        return this.id-o.id;
    }
}
