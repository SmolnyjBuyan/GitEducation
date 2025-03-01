package org.example.pngs;

import org.example.common.MainCanvas;
import org.example.common.Sprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Png extends Sprite {
    private static final Random rnd = new Random();
    private static final String pngPath = "src/main/resources/basketball.png";
    private final Image img;
    private float vX;
    private float vY;

    public Png() {
        halfHeight = 20 + rnd.nextFloat() * 50f;;
        halfWidth = halfHeight;

        try {
            BufferedImage rawImg = ImageIO.read(new File(pngPath));
            img = rawImg.getScaledInstance((int) halfWidth * 2, (int) halfHeight * 2, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        vX = 100f + rnd.nextFloat() * 200f;
        vY = 100f + rnd.nextFloat() * 200f;
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        g.drawImage(img, (int) getLeft(), (int) getTop(), null);
    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;

        if (getLeft() < canvas.getLeft()) {
            setLeft(canvas.getLeft());
            vX = -vX;
        }

        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }

        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }

        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }

    }
}
