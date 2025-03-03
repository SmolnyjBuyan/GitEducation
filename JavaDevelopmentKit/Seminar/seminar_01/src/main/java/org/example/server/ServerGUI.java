package org.example.server;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class ServerGUI extends JFrame implements ServerView {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;

    private JButton buttonStart;
    private JButton buttonStop;
    private JPanel buttonPanel;
    public JTextArea logs;
    private JScrollPane scrollPaneLogs;

    private Server server;

    public ServerGUI(Server server) {
        this.server = server;
        server.initServerView(this);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initButtonPanel();
        initLogsArea();

        add(scrollPaneLogs);
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
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
        updateLogs(server.getLogs());
    }

    private void startServer() {
        server.start();
        updateLogs(server.getLogs());
    }

    private void stopServer() {
        server.stop();
        updateLogs(server.getLogs());
    }

    @Override
    public void updateLogs(String logs) {
        this.logs.setText(server.getLogs());
    }
}
