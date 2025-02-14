import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
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
    private Cell[][] field;
    private int winLength;
    private GameOverStatus gameOverStatus;
    private boolean isInitialized;


    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        fieldSizeX = fSzX;
        fieldSizeY = fSzY;
        winLength = wLen;
        initMap();
        gameOverStatus = null;
        isInitialized = true;
        repaint();
    }

    Map() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
        isInitialized = false;
    }

    private void update(MouseEvent e) {
        if (gameOverStatus != null || !isInitialized) return;
        int x = e.getX() / cellWidth;
        int y = e.getY() / cellHeight;

        if (!playerTurn(field[y][x])) return;
        repaint();
        if (isGameOver(field[y][x])) return;

        Cell aiTurn = aiTurn();
        repaint();
        isGameOver(aiTurn);
    }

    private boolean playerTurn(Cell cell){
        System.out.printf("x = %d, y = %d" + System.lineSeparator(), cell.getX(), cell.getY());
        if (!isValidCell(cell.getX(), cell.getY()) || !cell.isEmpty()) return false;
        cell.setState(CellState.PLAYER);
        return true;
    }

    private boolean isGameOver(Cell cell) {
        if (checkWin(cell, winLength)) {
            gameOverStatus = cell.getState().getGameOverStatus();
            return true;
        } else if (isMapFull()) {
            gameOverStatus = GameOverStatus.STATE_DRAW;
            return true;
        }
        return false;
    }

    private void showMessageGameOver(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, getHeight() / 8));
        Graphics2D g2d = (Graphics2D) g;
        FontMetrics fm = g2d.getFontMetrics();
        Rectangle2D r = fm.getStringBounds(gameOverStatus.getMessage(), g2d);
        int x = (getWidth() - (int) r.getWidth()) / 2;
        int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
        g.setColor(Color.DARK_GRAY);
        int rectOffset = (int) (x * 0.05);
        g.fillRect(x - rectOffset, (getHeight() - fm.getHeight()) / 2,
                (int) (r.getWidth() + (rectOffset * 2) ), (int) r.getHeight());
        g.setColor(Color.ORANGE);
        g.drawString(gameOverStatus.getMessage(), x, y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInitialized) return;

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
                if (field[y][x].isEmpty()) continue;

                if (field[y][x].isPlayer()) {
                    g.setColor(Color.BLUE);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setStroke(new BasicStroke(3));
                    g2d.setRenderingHint
                            (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g.drawOval(cellWidth * x + DOT_PADDING, cellHeight * y + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2);

                } else if (field[y][x].isOpponent()) {
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

        if (gameOverStatus != null) {
            showMessageGameOver(g);
        }
    }

    private void initMap() {
        field = new Cell[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = new Cell(x, y);
            }
        }
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private Cell aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!field[y][x].isEmpty());
        field[y][x].setState(CellState.OPPONENT);
        return field[y][x];
    }

    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j].isEmpty()) return false;
            }
        }
        return true;
    }

    private boolean checkWin(Cell cell, int winLength) {
        if (checkRow(cell, winLength)) return true;

        if (checkColumn(cell, winLength)) return true;

        return checkFirstDiagonal(cell, winLength) || checkSecondDiagonal(cell, winLength);
    }

    private boolean checkRow(Cell cell, int winLength) {
        int count = 1;

        int i = cell.getX() + 1;
        while (i < fieldSizeX && field[cell.getY()][i].equals(cell)) {
            count++;
            i++;
        }
        i = cell.getX() - 1;
        while (i >= 0 && field[cell.getY()][i].equals(cell)) {
            count++;
            i--;
        }

        return count == winLength;
    }

    private boolean checkColumn(Cell cell, int winLength) {
        int count = 1;
        int y = cell.getY() + 1;
        while (y < fieldSizeY && field[y][cell.getX()].equals(cell)) {
            count++;
            y++;
        }
        y = cell.getY() - 1;
        while (y >= 0 && field[y][cell.getX()].equals(cell)) {
            count++;
            y--;
        }
        return count == winLength;
    }

    private boolean checkFirstDiagonal(Cell cell, int winLength) {
        int count = 1;
        int x = cell.getX() + 1;
        int y = cell.getY() + 1;
        while (y < fieldSizeY && x < fieldSizeX && field[y][x].equals(cell)) {
            count++;
            x++;
            y++;
        }
        x = cell.getX() - 1;
        y = cell.getY() - 1;
        while (y >= 0 && x >= 0 && field[y][x].equals(cell)) {
            count++;
            x--;
            y--;
        }
        return count == winLength;
    }

    private boolean checkSecondDiagonal(Cell cell, int winLength) {
        int count = 1;
        int x = cell.getX() + 1;
        int y = cell.getY() - 1;
        while (y >= 0 && x < fieldSizeX && field[y][x].equals(cell)) {
            count++;
            x++;
            y--;
        }
        x = cell.getX() - 1;
        y = cell.getY() + 1;
        while (y < fieldSizeY && x >= 0 && field[y][x].equals(cell)) {
            count++;
            x--;
            y++;
        }
        return count == winLength;
    }
}
