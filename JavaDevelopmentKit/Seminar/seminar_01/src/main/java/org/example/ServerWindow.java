package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class ServerWindow extends JFrame {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;

    private JButton buttonStart;
    private JButton buttonStop;
    private JPanel buttonPanel;
    private JTextArea logs;
    private JScrollPane scrollPaneLogs;
    private boolean isServerWorking;

    public ServerWindow() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initButtonPanel();
        initTextArea();

        add(scrollPaneLogs);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void startServer() {
        if (isServerWorking) {
            logs.append("Server is already running" + System.lineSeparator());
        } else {
            logs.append("Server is running" + System.lineSeparator());
            isServerWorking = true;
        }
    }

    private void stopServer() {
        if (!isServerWorking) {
            logs.append("Server is already stopped" + System.lineSeparator());
        } else {
            logs.append("Server is stopped" + System.lineSeparator());
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

    private void initTextArea() {
        logs = new JTextArea();
        logs.setBorder(new EmptyBorder(5, 5, 5, 5));
        scrollPaneLogs = new JScrollPane(logs);
        scrollPaneLogs.setBorder(BorderFactory.createCompoundBorder
                (new EmptyBorder(5, 5, 5, 5), new EtchedBorder()));
        logs.setBorder(new EmptyBorder(5, 5, 5, 5));
        logs.setEditable(false);
    }
}
