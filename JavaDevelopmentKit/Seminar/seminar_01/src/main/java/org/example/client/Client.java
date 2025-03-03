package org.example.client;

import org.example.server.Server;

public class Client {
    private final Server server;
    private final ClientView clientView;
    private User user;

    public Client(ClientView clientView, Server server) {
        this.clientView = clientView;
        this.server = server;
    }

    public boolean connect(String username, String password) {
        if (server.isOnline() && server.isUserValid(username, password)) {
            user = new User(username, password);
            server.addClient(this);
            server.updateOnlineUsersList();
            clientView.changeConnectionStatus(true);
            clientView.updateLogs(server.getLogs());
            return true;
        }
        return false;
    }

    public void disconnect() {
        clientView.changeConnectionStatus(false);
        server.removeClient(this);
        server.updateOnlineUsersList();
    }

    public void sendMessage(String message) {
        server.addMessage(user.getName() + ": " + message);
    }

    public void updateOnlineUsersList(String[] userNames) {
        clientView.updateOnlineUsersList(userNames);
    }

    public String getUserName() {
        return user.getName();
    }

    public void updateLogs(String logs) {
        clientView.updateLogs(logs);
    }
}
