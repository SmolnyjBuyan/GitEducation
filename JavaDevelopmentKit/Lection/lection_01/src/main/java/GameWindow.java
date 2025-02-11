import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private int WIDTH = 400;
    private int HEIGHT = 400;

    private JButton exit = new JButton("Exit");
    private JButton newGame = new JButton("New game");;

    private final JLabel welcomeImage = new JLabel(new ImageIcon(new ImageIcon("src/main/resources/Tic_tac_toe.svg.png").getImage()
                .getScaledInstance(380, 325, Image.SCALE_DEFAULT)));;
    private Map map;
    private final SettingsWindow settings;

    public GameWindow() {
        super("TicTacToe");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        add(welcomeImage);

        settings = new SettingsWindow(this);

        exit.addActionListener(e -> System.exit(0));
        newGame.addActionListener(e -> settings.setVisible(true));
        JPanel menu = new JPanel(new GridLayout(1, 2));
        menu.add(newGame);
        menu.add(exit);
        add(menu, BorderLayout.SOUTH);
        map = new Map();
        setVisible(true);
        }

    public void startNewGame(int mode, int fSzX, int fSzY, int wLen){
        welcomeImage.setVisible(false);
        add(map);
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }
}
