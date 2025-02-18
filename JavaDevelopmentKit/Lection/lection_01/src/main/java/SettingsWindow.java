import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int HEIGHT = 400;
    private static final int WIDTH = 350;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;


    SettingsWindow(GameWindow gameWindow) {
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(gameWindow);

        StylizedRadioButton btn1P = new StylizedRadioButton("1 PLAYER", true);
        StylizedRadioButton btn2P = new StylizedRadioButton("2 PLAYERS");
        ButtonGroup gameModeButtonGroup = new ButtonGroup();
        gameModeButtonGroup.add(btn1P);
        gameModeButtonGroup.add(btn2P);
        StylizedPanel gameModeButtonPanel = new StylizedPanel(new GridLayout(1, 2), "GAME MODE");
        gameModeButtonPanel.add(btn1P);
        gameModeButtonPanel.add(btn2P);

        StylizedPanel winLengthPanel = new StylizedPanel(new GridLayout(1, 1), "WIN LENGTH");
        StylizedSlider winLengthSlider = new StylizedSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        winLengthSlider.setExtent(MAX_FIELD_SIZE - MIN_FIELD_SIZE);
        winLengthPanel.add(winLengthSlider);

        StylizedPanel fieldSizePanel = new StylizedPanel(new GridLayout(2, 1), "FIELD SIZE");
        StylizedSlider fieldSizeSlider = new StylizedSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        StylizedLabel fieldSize = new StylizedLabel("3x3");
        fieldSizeSlider.addChangeListener
                (e -> {
                    fieldSize.setText(fieldSizeSlider.getValue() + "x" + fieldSizeSlider.getValue());
                    winLengthSlider.setExtent(MAX_FIELD_SIZE - fieldSizeSlider.getValue());
                    winLengthSlider.setValue(fieldSizeSlider.getValue());
                });
        fieldSizePanel.add(fieldSize);
        fieldSizePanel.add(fieldSizeSlider);

        StylizedButton startButton = new StylizedButton("START");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.addActionListener(e -> {
            gameWindow.startNewGame(1, fieldSizeSlider.getValue(),
                    fieldSizeSlider.getValue(), winLengthSlider.getValue());
            setVisible(false);
        });

        add(gameModeButtonPanel);
        add(fieldSizePanel);
        add(winLengthPanel);
        add(startButton);
    }



}
