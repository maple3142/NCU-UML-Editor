package net.maple3142.umleditor.components;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ClassObject extends BasicObject {
    public ClassObject(int xx, int yy) {
        super();
        width = 100;
        height = 120;
        x = xx;
        y = yy;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect(x, y, width, height);
        g.drawLine(x, y + height / 3, x + width, y + height / 3);
        g.drawLine(x, y + 2 * height / 3, x + width, y + 2 * height / 3);
        drawDots(g);
    }

    @Override
    public boolean checkInside(int xx, int yy) {
        return x <= xx && xx <= x + width && y <= yy && yy <= y + height;
    }
}
