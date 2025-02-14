import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {
    public static final int HEIGHT = 200;
    public static final int WIDTH = 300;

    JButton btn3x3 = new JButton("3x3");
    JButton btn5x5 = new JButton("5x5");
    SettingsWindow(GameWindow gameWindow) {
        setLayout(new GridLayout(3,1));
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(gameWindow);
        JLabel message = new JLabel("CHOOSE THE FIELD SIZE");
        message.setFont(new Font("Arial", Font.BOLD, 20));
        message.setHorizontalAlignment(SwingConstants.CENTER);
        btn3x3.setFont(new Font("Arial", Font.BOLD, 20));
        btn5x5.setFont(new Font("Arial", Font.BOLD, 20));
        add(message);
        add(btn3x3);
        add(btn5x5);
        btn3x3.addActionListener(e -> {
            gameWindow.startNewGame(0, 3,3, 3);
            setVisible(false);
        });
        btn5x5.addActionListener(e -> {
            gameWindow.startNewGame(0, 5,5, 4);
            setVisible(false);
        });
    }



}
