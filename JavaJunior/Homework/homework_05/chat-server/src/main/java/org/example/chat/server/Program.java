package org.example.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class Program {
    public static void main(String[] args) {
        try {
            Server server = new Server(new ServerSocket(1400));
            server.runServer();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
