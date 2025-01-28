import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private int WEIGHT = 400;
    private int HEIGHT = 400;

    private JButton exit = new JButton("Exit");
    private JButton newGame = new JButton("New game");;

    public GameWindow() {
        super("TicTacToe");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WEIGHT, HEIGHT);
        setLocationRelativeTo(null);

        add(new JLabel(new ImageIcon(new ImageIcon("src/main/resources/Tic_tac_toe.svg.png").getImage()
                .getScaledInstance(380, 325, Image.SCALE_DEFAULT))));

        exit.addActionListener(e -> System.exit(0));
        JPanel menu = new JPanel();
        menu.add(newGame);
        menu.add(exit);

        add(menu, BorderLayout.SOUTH);
        setVisible(true);
    }
}
