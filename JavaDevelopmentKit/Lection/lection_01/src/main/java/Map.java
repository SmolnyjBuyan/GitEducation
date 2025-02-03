import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    private int panelHeight;
    private int panelWidth;
    private int cellHeight;
    private int cellWidth;
    private int horizontalCellCount;
    private int verticalCellCount;

    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        horizontalCellCount = fSzX;
        verticalCellCount = fSzY;
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
        cellHeight = panelHeight / verticalCellCount;
        cellWidth = panelWidth / horizontalCellCount;

        for (int i = 1; i < horizontalCellCount; i++) {
            int x = cellWidth * i;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 1; i < verticalCellCount; i++) {
            int y = cellHeight * i;
            g.drawLine(0, y, panelWidth, y);
        }

    }
}
