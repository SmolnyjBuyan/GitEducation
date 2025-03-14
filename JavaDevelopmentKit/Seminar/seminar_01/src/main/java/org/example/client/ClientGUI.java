package org.example.client;

import org.example.server.Server;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientGUI extends JFrame implements ClientView {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;

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

    private Client client;

    public ClientGUI(Server server) throws HeadlessException {
        client = new Client(this, server);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                client.disconnect();
            }
        });

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
        panelCredentials.setLayout(new GridBagLayout());

        fieldUserName = new JTextField("Andrey",10);
        JLabel labelUserName = new JLabel("Name: ");
        labelUserName.setLabelFor(fieldUserName);

        fieldPassword = new JPasswordField("123456",10);
        JLabel labelPassword = new JLabel("Password: ");
        labelPassword.setLabelFor(fieldUserName);

        JLabel[] labels = {labelUserName, labelPassword};
        JTextField[] fields = {fieldUserName, fieldPassword};

        addLabelTextRows(labels, fields, panelCredentials);
    }
    private void initServerPanel() {
        panelServer = new JPanel();
        panelServer.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelServer.setLayout(new GridBagLayout());

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

        addLabelTextRows(labels, fields, panelServer);
    }

    private void addLabelTextRows(JLabel[] labels,
                                  JTextField[] textFields,
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

    private void initConnectionStatusPanel() {
        panelConnectionStatus = new JPanel();
        offlineStatus = new JLabel("Offline");
        offlineStatus.setForeground(Color.RED);
        onlineStatus = new JLabel("Online");
        onlineStatus.setForeground(Color.GREEN);
        onlineStatus.setVisible(false);
        buttonLogin = new JButton("Login");
        buttonLogin.addActionListener(e -> connect());
        buttonExit = new JButton("Exit");
        buttonExit.addActionListener(e -> client.disconnect());
        buttonExit.setVisible(false);
        panelConnectionStatus.add(buttonLogin);
        panelConnectionStatus.add(buttonExit);
        panelConnectionStatus.add(offlineStatus);
        panelConnectionStatus.add(onlineStatus);
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

    private void initLogArea() {
        panelLogs = new JPanel(new BorderLayout());
        logs = new JTextArea();
        logs.setBorder(new EmptyBorder(5, 5, 5, 5));
        scrollPaneLogs = new JScrollPane(logs);
        panelLogs.setBorder(new EmptyBorder(5, 5, 5, 5));
        logs.setEditable(false);
        panelLogs.add(scrollPaneLogs);
        panelLogs.setVisible(false);
    }

    private void initMessageArea() {
        messageArea = new JTextArea(4,0);
        messageArea.setBorder(new EmptyBorder(5, 5, 5, 5));
        messageArea.setLineWrap(true);
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
        buttonSend.addActionListener(e -> sendMessage());
        panelButton.add(buttonSend);
        panelSendMessage.add(scrollPaneMessage);
        panelSendMessage.add(panelButton);
        panelSendMessage.setVisible(false);
    }

    private void initUsersList() {
        panelUsers = new JPanel(new BorderLayout());
        listUsers = new JList<>();
        scrollPaneListUsers = new JScrollPane(listUsers);
        panelUsers.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelUsers.add(scrollPaneListUsers);
        panelUsers.setVisible(false);
    }

    @Override
    public void changeConnectionStatus(boolean isOnline) {
        offlineStatus.setVisible(!isOnline);
        onlineStatus.setVisible(isOnline);
        buttonExit.setVisible(isOnline);
        buttonLogin.setVisible(!isOnline);
        fieldUserName.setEnabled(!isOnline);
        fieldPassword.setEnabled(!isOnline);
        panelLogs.setVisible(isOnline);
        panelUsers.setVisible(isOnline);
        panelSendMessage.setVisible(isOnline);
    }

    @Override
    public void updateLogs(String logs) {
        this.logs.setText(logs);
    }

    @Override
    public void updateOnlineUsersList(String[] userNames) {
        listUsers.setListData(userNames);
    }

    private void sendMessage() {
        client.sendMessage(messageArea.getText() + System.lineSeparator());
        messageArea.setText("");
    }

    private void connect() {
        if (client.connect(fieldUserName.getText(), fieldPassword.getText())) {
            changeConnectionStatus(true);
        }
    }
}
