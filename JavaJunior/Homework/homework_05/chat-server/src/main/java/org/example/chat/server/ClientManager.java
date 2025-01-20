package org.example.chat.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable {
    private final Socket socket;
    private final static ArrayList<ClientManager> clients = new ArrayList<>();
    private String name;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    public ClientManager(Socket socket) {
        this.socket = socket;

        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = bufferedReader.readLine();
            clients.add(this);
            System.out.println(name + " подключился к чату!");
            broadcastMessage(name + " подключился к чату!");
        } catch (IOException e) {
            closeEverything();
        }
    }

    @Override
    public void run() {
        while (socket.isConnected()) {
            try {
                String messageFromClient = bufferedReader.readLine();
                broadcastMessage(messageFromClient);
            } catch (IOException e) {
                closeEverything();
                break;
            }
        }
    }

    private void broadcastMessage(String message) {
        for (ClientManager client : clients) {
            if (!client.name.equals(name)) {
                try {
                    client.bufferedWriter.write(message);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                } catch (IOException e) {
                    closeEverything();
                }
            }
        }
    }

    private void closeEverything() {
        removeClient();

        try {
            if (bufferedReader != null) bufferedReader.close();
            if (bufferedWriter != null) bufferedWriter.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeClient() {
        clients.remove(this);
        System.out.println(name + " покинул чат");
        broadcastMessage(name + " покинул чат");
    }
}
