package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ClientWindow extends JFrame {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;

    private ServerWindow server;
    private boolean isOnline;

    private JPanel panelConnection;
    private JPanel panelCredentials;
    private JTextField fieldUserName;
    private JPasswordField fieldPassword;
    private JPanel panelServer;
    private JPanel panelConnectionStatus;
    private JLabel offlineStatus;
    private JLabel onlineStatus;
    private JPanel panelLogs;
    private JTextArea logs;
    private JScrollPane scrollPaneLogs;
    private JScrollPane scrollPaneMessage;
    private JPanel panelSendMessage;
    private JTextArea messageArea;
    private JList<String> listUsers;
    private JScrollPane scrollPaneListUsers;
    private JButton buttonSend;
    private JButton buttonLogin;
    private JButton buttonExit;
    private JPanel panelUsers;

    public ClientWindow(ServerWindow server) {
        this.server = server;
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
        initLogArea();
        initUsersList();
        initMessageArea();
        initSendMessagePanel();
        add(panelConnection, BorderLayout.NORTH);
        add(panelLogs);
        add(panelUsers, BorderLayout.EAST);
        add(panelSendMessage, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void initCredentialsPanel() {
        panelCredentials = new JPanel();
        panelCredentials.setBorder(new EmptyBorder(5, 5, 5, 5));

        GridBagLayout gridbag = new GridBagLayout();
        panelCredentials.setLayout(gridbag);

        fieldUserName = new JTextField("Andrey",10);
        JLabel labelUserName = new JLabel("Name: ");
        labelUserName.setLabelFor(fieldUserName);

        fieldPassword = new JPasswordField("123456",10);
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

        JTextField fieldIp = new JTextField("127.0.0.1",10);
        fieldIp.setEnabled(false);
        JLabel labelIp = new JLabel("IP: ");
        labelIp.setLabelFor(fieldIp);

        JTextField fieldPort = new JTextField("5000",10);
        fieldPort.setEnabled(false);
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
        buttonLogin.addActionListener(e -> login());
        buttonExit = new JButton("Exit");
        buttonExit.addActionListener(e -> exit());
        buttonExit.setVisible(false);
        panelConnectionStatus.add(buttonLogin);
        panelConnectionStatus.add(buttonExit);
        panelConnectionStatus.add(offlineStatus);
        panelConnectionStatus.add(onlineStatus);
    }

    private void initLogArea() {
        panelLogs = new JPanel(new BorderLayout());
        logs = new JTextArea();
        logs.setBorder(new EmptyBorder(5, 5, 5, 5));
        scrollPaneLogs = new JScrollPane(logs);
        panelLogs.setBorder(new EmptyBorder(5, 5, 5, 5));
        logs.setEditable(false);
        panelLogs.add(scrollPaneLogs);
    }

    private void initMessageArea() {
        messageArea = new JTextArea(4,0);
        messageArea.setBorder(new EmptyBorder(5, 5, 5, 5));
        messageArea.setLineWrap(true);
        messageArea.setEditable(isOnline);
        messageArea.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke
                (KeyEvent.VK_ENTER, KeyEvent.SHIFT_DOWN_MASK, true), "Shift+Enter released");
        messageArea.getActionMap().put("Shift+Enter released", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                sendMessage();
            }
        });
    }


    private void initSendMessagePanel() {
        panelSendMessage = new JPanel();
        panelSendMessage.setLayout(new BoxLayout(panelSendMessage, BoxLayout.Y_AXIS));
        panelSendMessage.setBorder(new EmptyBorder(5, 5, 5,  5));
        scrollPaneMessage = new JScrollPane(messageArea);
        JPanel panelButton = new JPanel();
        buttonSend = new JButton("Send");
        buttonSend.setEnabled(isOnline);
        buttonSend.addActionListener(e -> sendMessage());
        panelButton.add(buttonSend);
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
        listUsers = new JList<>();
        scrollPaneListUsers = new JScrollPane(listUsers);
        panelUsers.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelUsers.add(scrollPaneListUsers);
    }

    private void changeConnectionStatus() {
        isOnline = !isOnline;
        offlineStatus.setVisible(!isOnline);
        onlineStatus.setVisible(isOnline);
        buttonExit.setVisible(isOnline);
        buttonLogin.setVisible(!isOnline);
        messageArea.setEditable(isOnline);
        buttonSend.setEnabled(isOnline);
        fieldUserName.setEnabled(!isOnline);
        fieldPassword.setEnabled(!isOnline);
    }

    private void login() {
        if (isConnectionValid()) {
            changeConnectionStatus();
            server.addClient(this);
            server.updateOnlineUsersList();
            updateLogs();
        }
    }

    private void exit() {
        changeConnectionStatus();
        server.removeClient(this);
        server.updateOnlineUsersList();
    }

    private boolean isConnectionValid() {
        return server.isUserValid(fieldUserName.getText(), fieldPassword.getText());
    }

    public void updateLogs() {
        logs.setText(server.getLogs());
    }

    private void sendMessage() {
        server.addMessage(fieldUserName.getText() + ": " + messageArea.getText() + System.lineSeparator());
        messageArea.setText("");
    }

    public String getUserName() {
        return fieldUserName.getText();
    }

    public void updateOnlineUsersList() {
        listUsers.setListData(server.getOnlineUserNames());
    }
}
