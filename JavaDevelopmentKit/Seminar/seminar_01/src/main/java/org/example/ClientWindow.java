package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class ClientWindow extends JFrame {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private JTextArea logs;
    private JScrollPane scrollPaneLogs;
    private JScrollPane scrollPaneMessage;
    private JPanel panelSendMessage;

    public ClientWindow() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initTextArea();
        initSendMessagePanel();
        add(scrollPaneLogs);
        add(panelSendMessage, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void initTextArea() {
        logs = new JTextArea();
        logs.setBorder(new EmptyBorder(5, 5, 5, 5));
        scrollPaneLogs = new JScrollPane(logs);
        scrollPaneLogs.setBorder(BorderFactory.createCompoundBorder
                (new EmptyBorder(5, 5, 5, 5), new EtchedBorder()));
        logs.setEditable(false);
    }

    private void initSendMessagePanel() {
        panelSendMessage = new JPanel();
        panelSendMessage.setLayout(new BoxLayout(panelSendMessage, BoxLayout.Y_AXIS));
        panelSendMessage.setBorder(new EmptyBorder(5, 5, 5,  5));
        JTextArea message = new JTextArea(4,0);
        message.setLineWrap(true);
        scrollPaneMessage = new JScrollPane(message);
        JPanel panelButton = new JPanel(new BorderLayout());
        JButton buttonSend = new JButton("Send");
        panelButton.add(buttonSend, BorderLayout.EAST);
        panelSendMessage.add(scrollPaneMessage);
        panelSendMessage.add(panelButton);
    }
}
