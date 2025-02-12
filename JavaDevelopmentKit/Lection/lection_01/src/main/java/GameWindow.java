import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private int WIDTH = 800;
    private int HEIGHT = 800;

    private JButton exit = new JButton("EXIT");
    private JButton newGame = new JButton("NEW GAME");;

    private final JLabel welcomeImage = new JLabel(new ImageIcon
            (new ImageIcon("src/main/resources/Tic_tac_toe.svg.png").getImage()
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
        exit.setFont(new Font("Arial", Font.BOLD, 20));
        newGame.setFont(new Font("Arial", Font.BOLD, 20));
        exit.addActionListener(e -> System.exit(0));
        newGame.addActionListener(e -> settings.setVisible(true));
        JPanel menu = new JPanel(new GridLayout(1, 2));
        menu.add(newGame);
        menu.add(exit);
        add(menu, BorderLayout.SOUTH);
        map = new Map();
        setVisible(true);
        add(map);
        }

    public void startNewGame(int mode, int fSzX, int fSzY, int wLen){
        welcomeImage.setVisible(false);
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }
}
