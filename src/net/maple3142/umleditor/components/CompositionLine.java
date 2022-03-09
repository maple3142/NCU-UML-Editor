package net.maple3142.umleditor.components;

import net.maple3142.umleditor.misc.IntPointXY;
import net.maple3142.umleditor.misc.Vector2;

import java.awt.Graphics;

public class CompositionLine extends Line {

    public CompositionLine(IntPointXY st, IntPointXY ed) {
        super(st, ed);
    }

    @Override
    public void draw(Graphics g) {
        int sx = start.getX();
        int sy = start.getY();
        int ex = end.getX();
        int ey = end.getY();
        g.setColor(lineColor);
        g.drawLine(sx, sy, ex, ey);
        double theta = Math.atan2(ey - sy, ex - sx);
        var a = new Vector2(ex, ey);
        var b = new Vector2(ex - sideLength, ey).rotateAround(a, theta - Math.PI / 4);
        var c = new Vector2(ex - sideLength, ey).rotateAndScaleAround(a, theta, Math.sqrt(2));
        var d = new Vector2(ex - sideLength, ey).rotateAround(a, theta - Math.PI / 4 + Math.PI / 2);
        g.fillPolygon(new int[]{a.getX(), b.getX(), c.getX(), d.getX()}, new int[]{a.getY(), b.getY(), c.getY(), d.getY()}, 4);
    }
}
