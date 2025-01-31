import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    public static final int HEIGHT = 200;
    public static final int WIDTH = 300;

    JButton btnStart = new JButton("Start new game");
    SettingsWindow(GameWindow gameWindow) {
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(gameWindow);
        add(btnStart);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(0, 3,3, 3);
                setVisible(false);
            }
        });
    }



}
