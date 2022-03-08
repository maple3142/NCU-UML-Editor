package net.maple3142.umleditor.components;

import java.awt.Color;

public abstract class Line implements UMLComponent {

    protected final int sideLength = 12;
    protected final Color lineColor = Color.CYAN;
    protected final Point2D start;
    protected final Point2D end;

    public Line(Point2D st, Point2D ed) {
        start = st;
        end = ed;
    }
}
