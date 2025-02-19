import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {
    private static final int HEIGHT = 400;
    private static final int WIDTH = 350;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;

    private final GameWindow gameWindow;
    private StylizedPanel panelGameMode;
    private StylizedPanel panelWinLength;
    private StylizedPanel panelFieldSize;
    private StylizedButton buttonStart;
    private StylizedSlider sliderWinLength;
    private StylizedSlider sliderFieldSize;
    private StylizedLabel fieldSizeValue;

    private static final String BUTTON_1P = "1 PLAYER";
    private static final String BUTTON_2P = "2 PLAYERS";
    private static final String LABEL_GAME_MODE = "GAME MODE";
    private static final String LABEL_WIN_LENGTH = "WIN LENGTH";
    private static final String LABEL_FIELD_SIZE = "FIELD SIZE";
    private static final String BUTTON_START = "START";


    SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(gameWindow);

        initGameModeWidget();
        initFieldSizeWidget();
        initWinLengthWidget();
        initStartButton();

        add(panelGameMode);
        add(panelFieldSize);
        add(panelWinLength);
        add(buttonStart);
    }

    private void initGameModeWidget() {
        StylizedRadioButton button1P = new StylizedRadioButton(BUTTON_1P, true);
        StylizedRadioButton button2P = new StylizedRadioButton(BUTTON_2P);
        ButtonGroup gameModeButtonGroup = new ButtonGroup();
        gameModeButtonGroup.add(button1P);
        gameModeButtonGroup.add(button2P);
        panelGameMode = new StylizedPanel(new FlowLayout(), LABEL_GAME_MODE);
        panelGameMode.add(button1P);
        panelGameMode.add(button2P);
    }

    private void initWinLengthWidget() {
        panelWinLength = new StylizedPanel(new GridLayout(1,1), LABEL_WIN_LENGTH);
        sliderWinLength = new StylizedSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderWinLength.setExtent(MAX_FIELD_SIZE - MIN_FIELD_SIZE);
        panelWinLength.add(sliderWinLength);
    }

    private void initFieldSizeWidget() {
        panelFieldSize = new StylizedPanel(new GridLayout(2, 1), LABEL_FIELD_SIZE);
        sliderFieldSize = new StylizedSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        fieldSizeValue = new StylizedLabel("");
        validateFieldSizeValue();
        sliderFieldSize.addChangeListener(e -> validateWidgets());
        panelFieldSize.add(fieldSizeValue);
        panelFieldSize.add(sliderFieldSize);
    }

    private void initStartButton() {
        buttonStart = new StylizedButton(BUTTON_START);
        buttonStart.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonStart.addActionListener(e -> startNewGame());
    }

    private void startNewGame() {
        gameWindow.startNewGame(1, sliderFieldSize.getValue(),
                sliderFieldSize.getValue(), sliderWinLength.getValue());
        setVisible(false);
    }

    private void validateFieldSizeValue() {
        fieldSizeValue.setText(sliderFieldSize.getValue() + "x" + sliderFieldSize.getValue());
    }

    private void validateWinLengthSlider() {
        sliderWinLength.setExtent(MAX_FIELD_SIZE - sliderFieldSize.getValue());
        sliderWinLength.setValue(sliderFieldSize.getValue());
    }

    private void validateWidgets() {
        validateFieldSizeValue();
        validateWinLengthSlider();
    }
}
