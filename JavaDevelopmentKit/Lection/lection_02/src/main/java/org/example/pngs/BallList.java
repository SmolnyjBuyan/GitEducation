package org.example.pngs;

import org.example.common.Interactable;
import org.example.common.MainCanvas;

import java.awt.*;
import java.util.ArrayList;

public class BallList extends ArrayList<Png> implements Interactable {

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        forEach(e -> e.update(canvas, deltaTime));
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        forEach(e -> e.render(canvas, g));
    }
}
