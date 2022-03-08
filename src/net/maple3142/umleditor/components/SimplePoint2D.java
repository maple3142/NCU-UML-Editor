package net.maple3142.umleditor.components;

public class SimplePoint2D implements Point2D {
    private final int x, y;

    public SimplePoint2D(int xx, int yy) {
        x = xx;
        y = yy;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
