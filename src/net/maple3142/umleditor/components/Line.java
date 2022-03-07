package net.maple3142.umleditor.components;

import java.awt.*;

public class Line implements UMLComponent {

    private ConnectionDot start;
    private ConnectionDot end;

    public Line(ConnectionDot st, ConnectionDot ed) {
        start = st;
        end = ed;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
    }
}
