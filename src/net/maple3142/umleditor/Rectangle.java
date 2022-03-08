package net.maple3142.umleditor;

public class Rectangle {
    // the original two point
    public final int x1, y1;
    public final int x2, y2;
    // x, y are the left top point
    // width and height are guaranteed to be positive
    public final int x, y;
    public final int width, height;

    public Rectangle(int x1, int y1, int x2, int y2) {
        // Immutable Rectangle class that could correctly construct rectangle for any two points
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        int xMin = Math.min(x1, x2);
        int xMax = Math.max(x1, x2);
        int yMin = Math.min(y1, y2);
        int yMax = Math.max(y1, y2);

        x = xMin;
        y = yMin;
        width = xMax - xMin;
        height = yMax - yMin;
    }
}
