package org.example;

public interface ClientView {
    void changeConnectionStatus(boolean isOnline);
    void updateLogs(String logs);
    void updateOnlineUsersList(String[] userNames);
}
