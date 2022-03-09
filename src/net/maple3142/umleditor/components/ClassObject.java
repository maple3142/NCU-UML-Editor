package net.maple3142.umleditor.components;

import net.maple3142.umleditor.misc.GraphicsUtils;
import net.maple3142.umleditor.misc.Rectangle;

import java.awt.Color;
import java.awt.Graphics;

public class ClassObject extends BasicObject {
    public ClassObject(int xx, int yy, int depth, String s) {
        super(depth);
        width = 100;
        height = 120;
        x = xx - width / 2;
        y = yy - height / 2;
        name = s;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect(x, y, width, height);
        g.drawLine(x, y + height / 3, x + width, y + height / 3);
        g.drawLine(x, y + 2 * height / 3, x + width, y + 2 * height / 3);
        var rect = new Rectangle(x, y, x + width, y + height / 3);
        GraphicsUtils.drawCenteredString(g, name, rect, g.getFont());
        drawDots(g);
    }
}
