package org.example.pngs;

import org.example.common.CanvasRepaintListener;
import org.example.common.Interactable;
import org.example.common.MainCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class MainWindow extends JFrame implements CanvasRepaintListener, MouseListener, Thread.UncaughtExceptionHandler {
    public static final int POS_X = 400;
    public static final int POS_Y = 200;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    private final List<Interactable> interactables = new ArrayList<>();
    private final BallList balls = new BallList();

    public MainWindow() throws HeadlessException {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Circles");
        interactables.add(balls);
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
        interactables.forEach(e -> e.update(canvas, deltaTime));
    }

    private void render(MainCanvas canvas, Graphics g) {
        interactables.forEach(e -> e.render(canvas, g));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            if (balls.size() >= 15) throw new MaxBallCountException();
            balls.add(new Png());
        } else if (SwingUtilities.isRightMouseButton(e) && !balls.isEmpty()) {
            balls.remove(balls.size() - 1);
        }

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

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
    }
}