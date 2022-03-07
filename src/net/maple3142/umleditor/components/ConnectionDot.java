package net.maple3142.umleditor.components;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionDot implements UMLComponent {
    private static final int width = 10;
    private static final int height = 10;

    private final BasicObject parent;
    public final int index;

    private List<Line> lines = new ArrayList<>();

    public ConnectionDot(BasicObject obj, int idx) {
        parent = obj;
        index = idx;
    }

    public int getX() {
        return parent.getDotX(index);
    }

    public int getY() {
        return parent.getDotY(index);
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    protected void drawLines(Graphics g) {
        for (var line : lines) {
            line.draw(g);
        }
    }

    @Override
    public void draw(Graphics g) {
        /* x, y are the center */
        g.setColor(Color.WHITE);
        g.fillRect(getX() - width / 2, getY() - height / 2, width, height);
    }
}