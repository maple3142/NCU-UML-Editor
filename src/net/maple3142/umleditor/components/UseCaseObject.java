package net.maple3142.umleditor.components;

import net.maple3142.umleditor.DrawingUtils;
import net.maple3142.umleditor.Rectangle;

import java.awt.Color;
import java.awt.Graphics;

public class UseCaseObject extends BasicObject {
    public UseCaseObject(int xx, int yy, int depth, String s) {
        super(depth);
        width = 120;
        height = 90;
        x = xx;
        y = yy;
        name = s;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawOval(x, y, width, height);
        var rect = new Rectangle(x, y, x + width, y + height);
        DrawingUtils.drawCenteredString(g, name, rect, g.getFont());
        drawDots(g);
    }
}
