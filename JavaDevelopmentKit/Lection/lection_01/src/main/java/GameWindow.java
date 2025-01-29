import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private int WIDTH = 400;
    private int HEIGHT = 400;

    private JButton exit = new JButton("Exit");
    private JButton newGame = new JButton("New game");;

    Map map;
    SettingsWindow settings;

    public GameWindow() {
        super("TicTacToe");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        add(new JLabel(new ImageIcon(new ImageIcon("src/main/resources/Tic_tac_toe.svg.png").getImage()
                .getScaledInstance(380, 325, Image.SCALE_DEFAULT))));

        Map map = new Map();
        settings = new SettingsWindow(this);

        exit.addActionListener(e -> System.exit(0));
        newGame.addActionListener(e -> settings.setVisible(true));
        JPanel menu = new JPanel(new GridLayout(1, 2));
        menu.add(newGame);
        menu.add(exit);
        add(menu, BorderLayout.SOUTH);
//        add(map);
        setVisible(true);



    }
}
