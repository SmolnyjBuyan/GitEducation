package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class ClientWindow extends JFrame {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private JTextArea logs;
    private JPanel panelSendMessage;

    public ClientWindow() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initTextArea();
        initSendMessagePanel();
        add(logs);
        add(panelSendMessage, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void initTextArea() {
        logs = new JTextArea();
        logs.setBorder(BorderFactory.createCompoundBorder
                (new EmptyBorder(5, 5, 5, 5), new EtchedBorder()));
        logs.setEditable(false);
    }

    private void initSendMessagePanel() {
        panelSendMessage = new JPanel(new FlowLayout());
        JTextField fieldMessage = new JTextField();
        panelSendMessage.add(fieldMessage);
    }
}
