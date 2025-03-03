package org.example.server;

import org.example.client.Client;

import java.util.ArrayList;
import java.util.List;

public class Server {
    private final String SERVER_RUN = "Server is running" + System.lineSeparator();
    private final String SERVER_ALREADY_RUN = "Server is already running" + System.lineSeparator();
    private final String SERVER_STOP = "Server is stopped" + System.lineSeparator();
    private final String SERVER_ALREADY_STOP = "Server is already stopped" + System.lineSeparator();

    private Repository repository;
    private ServerView serverView;
    private boolean isServerWorking;
    private List<Client> onlineClients;

    public Server(Repository repository) {
        isServerWorking = false;
        this.repository = repository;
        onlineClients = new ArrayList<>();
    }

    public void initServerView(ServerView serverView) {
        this.serverView = serverView;
    }

    public boolean isOnline() {
        return isServerWorking;
    }

    public void start() {
        if (isServerWorking) {
            repository.addMessage(SERVER_ALREADY_RUN);
        } else {
            repository.addMessage(SERVER_RUN);
            isServerWorking = true;
        }
    }

    public void stop() {
        if (!isServerWorking) {
            repository.addMessage(SERVER_ALREADY_STOP);
        } else {
            while (!onlineClients.isEmpty()) onlineClients.get(0).disconnect();
            repository.addMessage(SERVER_STOP);
            isServerWorking = false;
        }
    }

    public boolean isUserValid(String name, String password) {
        return repository.isUserValid(name, password);
    }

    public void addClient(Client client) {
        onlineClients.add(client);
    }

    public void updateOnlineUsersList() {
        onlineClients.forEach(c -> c.updateOnlineUsersList(getOnlineUsersNames()));
    }

    public String getLogs() {
        return repository.readLogs();
    }

    public void removeClient(Client client) {
        onlineClients.remove(client);
    }

    public void addMessage(String message) {
        repository.addMessage(message);
        String logs = getLogs();
        onlineClients.forEach(c -> c.updateLogs(logs));
        serverView.updateLogs(logs);
    }

    public String[] getOnlineUsersNames() {
        return onlineClients.stream().map(Client::getUserName).toArray(String[]::new);
    }
}
