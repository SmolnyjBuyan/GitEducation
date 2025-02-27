package org.example.circles;

import org.example.common.CanvasRepaintListener;
import org.example.common.Interactable;
import org.example.common.MainCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainWindow extends JFrame implements CanvasRepaintListener, MouseListener {
    public static final int POS_X = 400;
    public static final int POS_Y = 200;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    private final Interactable[] interactables = new Interactable[10];

    public MainWindow() throws HeadlessException {
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Circles");
        interactables[0] = new Background();
        for (int i = 1; i < interactables.length; i++) {
            interactables[i] = new Ball();
        }
        MainCanvas canvas = new MainCanvas(this);
        canvas.addMouseListener(this);
        add(canvas);
        setVisible(true);
    }

    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].render(canvas, g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked!");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Pressed!");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Released!");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Entered!");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Exited!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }
}