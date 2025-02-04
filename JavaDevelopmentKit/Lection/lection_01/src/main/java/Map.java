import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {
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
}
