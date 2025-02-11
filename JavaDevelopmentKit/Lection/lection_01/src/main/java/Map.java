import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    private static final Random RANDOM = new Random();
    public static final int DOT_PADDING = 3;
    private int panelHeight;
    private int panelWidth;
    private int cellHeight;
    private int cellWidth;
    private int fieldSizeX;
    private int fieldSizeY;
    private Dot[][] field;

    private GameOverStatus gameOverStatus;


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
        playerTurn(e);
        repaint();
        if (checkWin(Dot.PLAYER)) System.out.println("GOOOOAAL");
//        if (isGameOver(GameOverStatus.STATE_WIN_PLAYER)) return;
        aiTurn();
        repaint();
//        isGameOver(GameOverStatus.STATE_WIN_OPPONENT);
    }

    private void playerTurn(MouseEvent e){
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        System.out.printf("x = %d, y = %d" + System.lineSeparator(), cellX, cellY);
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellY][cellX] = Dot.PLAYER;
    }

    private boolean isGameOver(Dot dot) {
        if (checkWin(dot)) {
            this.gameOverStatus = dot.getGameOverStatus();
            return true;
        } else if (isMapFull()) {
            this.gameOverStatus = GameOverStatus.STATE_DRAW;
            return true;
        }
        return false;
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

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == Dot.EMPTY) continue;

                if (field[y][x] == Dot.PLAYER) {
                    g.setColor(Color.BLUE);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setStroke(new BasicStroke(3));
                    g2d.setRenderingHint
                            (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g.drawOval(cellWidth * x + DOT_PADDING, cellHeight * y + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2);

                } else if (field[y][x] == Dot.OPPONENT) {
                    g.setColor(Color.RED);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setStroke(new BasicStroke(3));
                    g2d.setRenderingHint
                            (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g.drawLine(cellWidth * x + DOT_PADDING, cellHeight * y + DOT_PADDING,
                            cellWidth * (x + 1) - DOT_PADDING, cellHeight * (y + 1) - DOT_PADDING);
                    g.drawLine(cellWidth * x + DOT_PADDING, cellHeight * (y + 1) - DOT_PADDING,
                            cellWidth * (x + 1) - DOT_PADDING, cellHeight * y + DOT_PADDING);
                } else {
                    throw new RuntimeException("Unexpected value " + field[y][x] +
                            " in cell: x=" + x + " y=" + y);
                }
            }
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

    private boolean checkWin(Dot dot) {
        for (int y = 0; y < fieldSizeY; y++) {
            if (checkRow(y, dot)) return true;
        }

        for (int x = 0; x < fieldSizeX; x++) {
            if (checkColumn(x, dot)) return true;
        }

        return checkFirstDiagonal(dot) || checkSecondDiagonal(dot);
    }

    private boolean checkRow(int y, Dot dot) {
        for (int x = 0; x < fieldSizeX; x++) {
            if (field[y][x] != dot) return false;
        }
        return true;
    }

    private boolean checkColumn(int x, Dot dot) {
        for (int y = 0; y < fieldSizeY; y++) {
            if (field[y][x] != dot) return false;
        }
        return true;
    }

    private boolean checkSecondDiagonal(Dot dot) {
        for (int y = fieldSizeY - 1, x = 0; y >= 0; y--, x++) {
            if (field[y][x] != dot) return false;
        }
        return true;
    }

    private boolean checkFirstDiagonal(Dot dot) {
        for (int y = 0, x = 0; y < fieldSizeY; y++, x++) {
            if (field[y][x] != dot) return false;
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
