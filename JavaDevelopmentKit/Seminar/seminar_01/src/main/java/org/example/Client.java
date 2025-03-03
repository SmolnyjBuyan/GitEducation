package org.example;

public class Client {
    private Server server;
    private User user;
    private ClientView clientView;

    public void connect() {
        if (server.isOnline() && server.isUserValid(user.getName(), user.getPassword())) {
            server.addClient(this);
            server.updateOnlineUsersList();
            clientView.changeConnectionStatus(true);
            clientView.updateLogs(server.getLogs());
        }
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
}
