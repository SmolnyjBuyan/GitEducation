package org.example;

import org.example.client.ClientGUI;
import org.example.server.FileData;
import org.example.server.Server;
import org.example.server.ServerGUI;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(new FileData());
        new ServerGUI(server);
        new ClientGUI(server);
        new ClientGUI(server);
    }
}