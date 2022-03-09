package net.maple3142.umleditor.components;

import net.maple3142.umleditor.misc.IntPointXY;

import java.awt.Color;

public abstract class Line implements UMLComponent {

    protected final int sideLength = 12;
    protected final Color lineColor = Color.CYAN;
    protected final IntPointXY start;
    protected final IntPointXY end;

    public Line(IntPointXY st, IntPointXY ed) {
        start = st;
        end = ed;
    }
}
