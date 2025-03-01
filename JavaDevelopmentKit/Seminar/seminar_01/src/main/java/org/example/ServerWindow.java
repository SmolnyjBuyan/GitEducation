package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow extends JFrame {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private final Path LOG_HISTORY_FILE_PATH = Paths.get("src/main/resources/history");
    private final String SERVER_RUN = "Server is running" + System.lineSeparator();
    private final String SERVER_ALREADY_RUN = "Server is already running" + System.lineSeparator();
    private final String SERVER_STOP = "Server is stopped" + System.lineSeparator();
    private final String SERVER_ALREADY_STOP = "Server is already stopped" + System.lineSeparator();

    private DataBase dataBase;
    private JButton buttonStart;
    private JButton buttonStop;
    private JPanel buttonPanel;
    public JTextArea logs;
    private JScrollPane scrollPaneLogs;
    private boolean isServerWorking;
    private List<ClientWindow> onlineClients;

    public ServerWindow() {
        dataBase = new DataBase();
        onlineClients = new ArrayList<>();
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        validateLogFile();
        initButtonPanel();
        initLogsArea();

        add(scrollPaneLogs);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void startServer() {
        if (isServerWorking) {
            logs.append(SERVER_ALREADY_RUN);
            addMessageToHistoryFile(SERVER_ALREADY_RUN);
        } else {
            logs.append(SERVER_RUN);
            addMessageToHistoryFile(SERVER_RUN);
            isServerWorking = true;
        }
    }

    private void stopServer() {
        if (!isServerWorking) {
            logs.append(SERVER_ALREADY_STOP);
            addMessageToHistoryFile(SERVER_ALREADY_STOP);
        } else {
            while (!onlineClients.isEmpty()) onlineClients.get(0).disconnect();
            logs.append(SERVER_STOP);
            addMessageToHistoryFile(SERVER_STOP);
            isServerWorking = false;
        }
    }

    private void initButtonPanel() {
        buttonPanel = new JPanel(new FlowLayout());
        buttonStart = new JButton("Start");
        buttonStop = new JButton("Stop");
        buttonStart.addActionListener(e -> startServer());
        buttonStop.addActionListener(e -> stopServer());
        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);
    }

    private void initLogsArea() {
        logs = new JTextArea();
        logs.setBorder(new EmptyBorder(5, 5, 5, 5));
        scrollPaneLogs = new JScrollPane(logs);
        scrollPaneLogs.setBorder(BorderFactory.createCompoundBorder
                (new EmptyBorder(5, 5, 5, 5), new EtchedBorder()));
        logs.setBorder(new EmptyBorder(5, 5, 5, 5));
        logs.setEditable(false);
        logs.setText(readHistory());
    }

    private String readHistory() {
        StringBuilder chatHistory = new StringBuilder();

        try (BufferedReader reader = Files.newBufferedReader(LOG_HISTORY_FILE_PATH)) {
            String line;
            while ((line = reader.readLine()) != null) {
                chatHistory.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return chatHistory.toString();
    }

    private void validateLogFile() {
        if (!Files.exists(LOG_HISTORY_FILE_PATH)) {
            try {
                Files.createFile(LOG_HISTORY_FILE_PATH);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isUserValid(String username, String password) {
        return dataBase.isUserValid(username, password);
    }

    public void addMessage(String message) {
        logs.append(message);
        addMessageToHistoryFile(message);
        onlineClients.forEach(ClientWindow::updateLogs);
    }

    private void addMessageToHistoryFile(String message) {
        try {
            Files.write(LOG_HISTORY_FILE_PATH, message.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getLogs() {
        return logs.getText();
    }

    public void addClient(ClientWindow clientWindow) {
        onlineClients.add(clientWindow);
    }

    public void removeClient(ClientWindow clientWindow) {
        onlineClients.remove(clientWindow);
    }

    public String[] getOnlineUserNames() {
        return onlineClients.stream().map(ClientWindow::getUserName).toArray(String[]::new);
    }

    public void updateOnlineUsersList() {
        onlineClients.forEach(ClientWindow::updateOnlineUsersList);
    }

    public boolean isOnline() {
        return isServerWorking;
    }
}
