package org.example.server;

public interface Repository {
    String readLogs();
    boolean isUserValid(String name, String password);
    void addMessage(String s);
}
