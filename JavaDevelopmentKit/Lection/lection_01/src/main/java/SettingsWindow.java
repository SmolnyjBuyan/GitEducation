import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {
    private static final int HEIGHT = 400;
    private static final int WIDTH = 350;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;

    private final GameWindow gameWindow;
    private StylizedPanel gameModePanel;
    private StylizedPanel winLengthPanel;
    private StylizedPanel fieldSizePanel;
    private StylizedButton startButton;
    private StylizedSlider winLengthSlider;
    private StylizedSlider fieldSizeSlider;


    SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(gameWindow);

        initGameModeWidget();
        initFieldSizeWidget();
        initWinLengthWidget();
        initStartButton();

        add(gameModePanel);
        add(fieldSizePanel);
        add(winLengthPanel);
        add(startButton);
    }

    private void initGameModeWidget() {
        StylizedRadioButton btn1P = new StylizedRadioButton("1 PLAYER", true);
        StylizedRadioButton btn2P = new StylizedRadioButton("2 PLAYERS");
        ButtonGroup gameModeButtonGroup = new ButtonGroup();
        gameModeButtonGroup.add(btn1P);
        gameModeButtonGroup.add(btn2P);
        gameModePanel = new StylizedPanel(new FlowLayout(), "GAME MODE");
        gameModePanel.add(btn1P);
        gameModePanel.add(btn2P);
    }

    private void initWinLengthWidget() {
        winLengthPanel = new StylizedPanel(new GridLayout(1, 1), "WIN LENGTH");
        winLengthSlider = new StylizedSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        winLengthSlider.setExtent(MAX_FIELD_SIZE - MIN_FIELD_SIZE);
        winLengthPanel.add(winLengthSlider);
    }

    private void initFieldSizeWidget() {
        fieldSizePanel = new StylizedPanel(new GridLayout(2, 1), "FIELD SIZE");
        fieldSizeSlider = new StylizedSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        StylizedLabel fieldSize = new StylizedLabel("3x3");
        fieldSizeSlider.addChangeListener
                (e -> {
                    fieldSize.setText(fieldSizeSlider.getValue() + "x" + fieldSizeSlider.getValue());
                    winLengthSlider.setExtent(MAX_FIELD_SIZE - fieldSizeSlider.getValue());
                    winLengthSlider.setValue(fieldSizeSlider.getValue());
                });
        fieldSizePanel.add(fieldSize);
        fieldSizePanel.add(fieldSizeSlider);
    }

    private void initStartButton() {
        startButton = new StylizedButton("START");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.addActionListener(e -> startNewGame());
    }

    private void startNewGame() {
        gameWindow.startNewGame(1, fieldSizeSlider.getValue(),
                fieldSizeSlider.getValue(), winLengthSlider.getValue());
        setVisible(false);
    }
}
