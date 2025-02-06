import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    private static final Random RANDOM = new Random();
    private int panelHeight;
    private int panelWidth;
    private int cellHeight;
    private int cellWidth;
    private int fieldSizeX;
    private int fieldSizeY;
    private Dot[][] field;


    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        fieldSizeX = fSzX;
        fieldSizeY = fSzY;
        initMap();
        repaint();
    }

    Map() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }

    private void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        System.out.printf("x = %d, y = %d" + System.lineSeparator(), cellX, cellY);
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellY][cellX] = Dot.PLAYER;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        g.setColor(Color.BLACK);
        panelHeight = getHeight();
        panelWidth = getWidth();
        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 1; i < fieldSizeX; i++) {
            int x = cellWidth * i;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 1; i < fieldSizeY; i++) {
            int y = cellHeight * i;
            g.drawLine(0, y, panelWidth, y);
        }

    }

    private void initMap() {
        field = new Dot[fieldSizeY][fieldSizeX];

        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = Dot.EMPTY;
            }
        }
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == Dot.EMPTY;
    }

    private void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = Dot.OPPONENT;
    }

    private boolean checkWin() {
        for (int i = 0; i < fieldSizeY; i++) {
            if (checkRow(i)) return true;
        }

        for (int j = 0; j < fieldSizeX; j++) {
            if (checkColumn(j)) return true;
        }

        return checkFirstDiagonal() || checkSecondDiagonal();
    }

    private boolean checkRow(int rowNumber) {
        for (int j = 1; j < fieldSizeX; j++) {
            if (field[rowNumber][0] != field[rowNumber][j]) return false;
        }
        return true;
    }

    private boolean checkColumn(int columnNumber) {
        for (int i = 1; i < fieldSizeY; i++) {
            if (field[0][columnNumber] != field[i][columnNumber]) return false;
        }
        return true;
    }

    private boolean checkSecondDiagonal() {
        for (int i = fieldSizeY - 2, k = 1; i >= 0; i--, k++) {
            if (field[fieldSizeY - 1][0] != field[i][k]) return false;
        }
        return true;
    }

    private boolean checkFirstDiagonal() {
        for (int i = 1, k = 1; i < fieldSizeY; i++, k++) {
            if (field[0][0] != field[i][k]) return false;
        }
        return true;
    }

    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == Dot.EMPTY) return false;
            }
        }
        return true;
    }
}
