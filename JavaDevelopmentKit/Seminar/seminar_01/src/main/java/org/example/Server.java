package org.example;

import java.util.List;

public class Server {
    private List<Client> onlineClients;

    public boolean isOnline() {
        return false;
    }

    public boolean isUserValid(String name, String password) {
        return false;
    }

    public void addClient(Client client) {
    }

    public void updateOnlineUsersList() {
        onlineClients.forEach(c -> c.updateOnlineUsersList(getOnlineUsersNames()));
    }

    public String getLogs() {
        return "";
    }

    public void removeClient(Client client) {
    }

    public void addMessage(String s) {
    }

    public String[] getOnlineUsersNames() {
        return onlineClients.stream().map(Client::getUserName).toArray(String[]::new);
    }
}
