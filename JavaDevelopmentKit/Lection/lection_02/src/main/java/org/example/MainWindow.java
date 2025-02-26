package org.example;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    public MainWindow() throws HeadlessException {
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Circles");

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);
        setVisible(true);
    }

    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime){}
    private void render(MainCanvas canvas, Graphics g){}
}
