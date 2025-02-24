package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientWindow extends JFrame {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;

    private boolean isOnline;

    private JPanel panelConnection;
    private JPanel panelCredentials;
    private JPanel panelServer;
    private JPanel panelConnectionStatus;
    private JLabel offlineStatus;
    private JLabel onlineStatus;
    private JTextArea logs;
    private JScrollPane scrollPaneLogs;
    private JScrollPane scrollPaneMessage;
    private JPanel panelSendMessage;
    private JButton buttonLogin;
    private JPanel panelUsers;

    public ClientWindow() {
        setSize(WIDTH, HEIGHT);
        isOnline = false;
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initCredentialsPanel();
        initServerPanel();
        initConnectionStatusPanel();
        initConnectionPanel();
        initTextArea();
        initUsersList();
        initSendMessagePanel();
        add(panelConnection, BorderLayout.NORTH);
        add(scrollPaneLogs);
        add(panelUsers, BorderLayout.EAST);
        add(panelSendMessage, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void initCredentialsPanel() {
        panelCredentials = new JPanel();
        panelCredentials.setBorder(new EmptyBorder(5, 5, 5, 5));

        GridBagLayout gridbag = new GridBagLayout();
        panelCredentials.setLayout(gridbag);

        JTextField fieldUserName = new JTextField(10);
        JLabel labelUserName = new JLabel("Name: ");
        labelUserName.setLabelFor(fieldUserName);

        JTextField fieldPassword = new JTextField(10);
        JLabel labelPassword = new JLabel("Password: ");
        labelPassword.setLabelFor(fieldUserName);

        JLabel[] labels = {labelUserName, labelPassword};
        JTextField[] fields = {fieldUserName, fieldPassword};

        addLabelTextRows(labels, fields, gridbag, panelCredentials);
    }

    private void initServerPanel() {
        panelServer = new JPanel();
        panelServer.setBorder(new EmptyBorder(5, 5, 5, 5));
        GridBagLayout gridbag = new GridBagLayout();
        panelServer.setLayout(gridbag);

        JTextField fieldIp = new JTextField(10);
        JLabel labelIp = new JLabel("IP: ");
        labelIp.setLabelFor(fieldIp);

        JTextField fieldPort = new JTextField(10);
        JLabel labelPort = new JLabel("Port: ");
        labelPort.setLabelFor(fieldPort);

        JLabel[] labels = {labelIp, labelPort};
        JTextField[] fields = {fieldIp, fieldPort};

        addLabelTextRows(labels, fields, gridbag, panelServer);
    }

    private void initConnectionPanel() {
        panelConnection = new JPanel();
        panelConnection.setLayout(new BoxLayout(panelConnection, BoxLayout.Y_AXIS));
        panelConnection.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5,5,5,5),
                BorderFactory.createEtchedBorder()));
        JPanel panelInputFields = new JPanel();
        panelInputFields.setLayout(new BoxLayout(panelInputFields, BoxLayout.X_AXIS));
        panelInputFields.add(panelCredentials);
        panelInputFields.add(panelServer);
        panelConnection.add(panelInputFields);
        panelConnection.add(panelConnectionStatus);
    }

    private void initConnectionStatusPanel() {

        panelConnectionStatus = new JPanel();
        offlineStatus = new JLabel("Offline");
        offlineStatus.setForeground(Color.RED);
        onlineStatus = new JLabel("Online");
        onlineStatus.setForeground(Color.GREEN);
        onlineStatus.setVisible(false);
        buttonLogin = new JButton("Login");
        buttonLogin.addActionListener(e -> changeConnectionStatus());
        panelConnectionStatus.add(buttonLogin);
        panelConnectionStatus.add(offlineStatus);
        panelConnectionStatus.add(onlineStatus);
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

    private void addLabelTextRows(JLabel[] labels,
                                  JTextField[] textFields,
                                  GridBagLayout gridbag,
                                  Container container) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST;
        int numLabels = labels.length;

        for (int i = 0; i < numLabels; i++) {
            c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
            c.fill = GridBagConstraints.NONE;      //reset to default
            c.weightx = 0.0;                       //reset to default
            container.add(labels[i], c);

            c.gridwidth = GridBagConstraints.REMAINDER;     //end row
            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 1.0;
            container.add(textFields[i], c);
        }
    }
    private void initUsersList() {
        panelUsers = new JPanel(new BorderLayout());
        String[] users = {"Андрей", "Дмитрий", "Сергей", "Илья"};
        JList<String> listUsers = new JList<>(users);
        panelUsers.setBorder(BorderFactory.createCompoundBorder
                (new EmptyBorder(5, 5, 5, 5), new EtchedBorder()));
        panelUsers.add(listUsers);
    }

    private void changeConnectionStatus() {
        offlineStatus.setVisible(isOnline);
        onlineStatus.setVisible(!isOnline);
        isOnline = !isOnline;
    }
}
