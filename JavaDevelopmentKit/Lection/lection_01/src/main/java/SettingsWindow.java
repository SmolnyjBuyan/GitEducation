import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {
    public static final int HEIGHT = 300;
    public static final int WIDTH = 275;

    SettingsWindow(GameWindow gameWindow) {
        setLayout(new GridLayout(4,1));
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(gameWindow);

        StylizedRadioButton btn1P = new StylizedRadioButton("1 PLAYER", true);
        StylizedRadioButton btn2P = new StylizedRadioButton("2 PLAYERS");
        ButtonGroup gameModeButtonGroup = new ButtonGroup();
        gameModeButtonGroup.add(btn1P);
        gameModeButtonGroup.add(btn2P);
        StylizedButtonPanel gameModeButtonPanel = new StylizedButtonPanel(new GridLayout(1, 2), "GAME MODE");
        gameModeButtonPanel.add(btn1P);
        gameModeButtonPanel.add(btn2P);
        add(gameModeButtonPanel);

//        StylizedRadioButton btn3x3 = new StylizedRadioButton("3x3", true);
//        StylizedRadioButton btn5x5 = new StylizedRadioButton("5x5");
//        ButtonGroup fieldSizeButtonGroup = new ButtonGroup();
//        fieldSizeButtonGroup.add(btn3x3);
//        fieldSizeButtonGroup.add(btn5x5);
//        StylizedButtonPanel fieldSizeButtonPanel = new StylizedButtonPanel(new GridLayout(1, 2), "FIELD SIZE");
//        fieldSizeButtonPanel.add(btn3x3);
//        fieldSizeButtonPanel.add(btn5x5);
//        add(fieldSizeButtonPanel);

        StylizedLabel fieldSize = new StylizedLabel("FIELD SIZE");
        StylizedSlider fieldSizeSlider = new StylizedSlider(3, 10);
        add(fieldSize);
        add(fieldSizeSlider);

//        btn3x3.addActionListener(e -> {
//            gameWindow.startNewGame(0, 3, 3, 3);
//            setVisible(false);
//        });
//        btn5x5.addActionListener(e -> {
//            gameWindow.startNewGame(0, 5,5, 4);
//            setVisible(false);
//        });
    }



}
