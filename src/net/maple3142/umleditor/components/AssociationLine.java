package net.maple3142.umleditor.components;

import net.maple3142.umleditor.DrawingUtils;

import java.awt.Graphics;

public class AssociationLine extends Line {

    public AssociationLine(Point2D st, Point2D ed) {
        super(st, ed);
    }

    @Override
    public void draw(Graphics g) {
        DrawingUtils.drawAssociationLine(g, lineColor, start.getX(), start.getY(), end.getX(), end.getY(), sideLength);
    }
}
