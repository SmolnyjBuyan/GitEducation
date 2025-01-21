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
                sendMessage(messageFromClient);
            } catch (IOException e) {
                closeEverything();
                break;
            }
        }
    }

    private void sendMessage(String message) {
        if (message.startsWith("@")) {
            String[] parsedMessage = message.substring(1).split(" ", 2);
            String clientName = parsedMessage[0];
            message = parsedMessage[1];
            if (!sendPersonalMessage(name + ": " + message, clientName)) {
                try {
                    this.bufferedWriter.write("Сервер: Такого пользователя нет в чате!");
                    this.bufferedWriter.newLine();
                    this.bufferedWriter.flush();
                } catch (IOException e) {
                    closeEverything();
                }
            }
        } else {
            broadcastMessage(name + ": " + message);
        }
    }

    private boolean sendPersonalMessage(String message, String toWhom) {
        for (ClientManager client : clients) {
            if (client.name.equals(toWhom)) {
                try {
                    client.bufferedWriter.write(message);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                    return true;
                } catch (IOException e) {
                    closeEverything();
                }
            }
        }
        return false;
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

    private boolean checkForTag(String message){
        return false;
    }
}
