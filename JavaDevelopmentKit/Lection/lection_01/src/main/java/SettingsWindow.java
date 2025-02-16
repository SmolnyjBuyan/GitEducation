import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {
    public static final int HEIGHT = 200;
    public static final int WIDTH = 300;

//    JButton btn3x3 = new JButton("3x3");
//    JButton btn5x5 = new JButton("5x5");
    JRadioButton btn1P = new JRadioButton("1 PLAYER", true);
    JRadioButton btn2P = new JRadioButton("2 PLAYERS");

    SettingsWindow(GameWindow gameWindow) {
        setLayout(new GridLayout(4,1));
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(gameWindow);

        JLabel message = new JLabel("CHOOSE YOUR GAME MODE");
        message.setFont(new Font("Arial", Font.BOLD, 20));
        message.setHorizontalAlignment(SwingConstants.CENTER);
        btn1P.setFont(new Font("Arial", Font.BOLD, 15));
        btn2P.setFont(new Font("Arial", Font.BOLD, 15));
        ButtonGroup gameModeButtonsGroup = new ButtonGroup();
        gameModeButtonsGroup.add(btn1P);
        gameModeButtonsGroup.add(btn2P);
        JPanel gameModeButtonsPanel = new JPanel(new GridLayout(1, 2));
        gameModeButtonsPanel.add(btn1P);
        gameModeButtonsPanel.add(btn2P);
        btn1P.setHorizontalAlignment(SwingConstants.CENTER);
        btn2P.setHorizontalAlignment(SwingConstants.CENTER);
        add(message);
        add(gameModeButtonsPanel);
//        btn3x3.addActionListener(e -> {
//            gameWindow.startNewGame(0, 3,3, 3);
//            setVisible(false);
//        });
//        btn5x5.addActionListener(e -> {
//            gameWindow.startNewGame(0, 5,5, 4);
//            setVisible(false);
//        });
    }



}
