package net.maple3142.umleditor.components;

import java.awt.*;

import net.maple3142.umleditor.Rectangle;

public abstract class BasicObject implements SelectableObject {
    protected int width;
    protected int height;
    protected int x;
    protected int y;
    protected boolean isSelected = false;

    /* connection dots on 4 sides */ ConnectionDot[] dots = new ConnectionDot[4];

    /* connection dot constants */
    /* orientation: up, right, down, left */
    private final int[] dirX = {0, 1, 0, -1};
    private final int[] dirY = {-1, 0, 1, 0};

    public BasicObject() {
        for (int i = 0; i < 4; i++) {
            dots[i] = new ConnectionDot(this, i);
        }
    }

    protected int getDotX(int idx) {
        int hx = width / 2;
        int cx = x + hx;
        return cx + dirX[idx] * hx;
    }

    protected int getDotY(int idx) {
        int hy = height / 2;
        int cy = y + hy;
        return cy + dirY[idx] * hy;
    }

    protected void drawDots(Graphics g) {
        for (int i = 0; i < 4; i++) {
            if (isSelected) {
                dots[i].draw(g);
            }
            dots[i].drawLines(g);
        }
    }

    public ConnectionDot getClosestConnectionDot(int xx, int yy) {
        // easy maffs
        int cx = x + width / 2;
        int cy = y + height / 2;
        double angle = Math.atan2(-(yy - cy), xx - cx);  // angle in [-pi, pi]
        double pi4 = Math.PI / 4;
        if (pi4 <= angle && angle < pi4 * 3) {
            return dots[0];
        }
        if (pi4 * 3 <= angle || angle < -pi4 * 3) {
            return dots[3];
        }
        if (-pi4 <= angle && angle < pi4) {
            return dots[1];
        }
        return dots[2];
    }

    @Override
    public void focus() {
        isSelected = true;
    }

    @Override
    public void blur() {
        isSelected = false;
    }

    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    @Override
    public boolean isPointInside(int xx, int yy) {
        return x <= xx && xx <= x + width && y <= yy && yy <= y + height;
    }

    @Override
    public boolean isFullyInsideRect(Rectangle rect) {
        return rect.x <= x && x + width <= rect.x + rect.width &&
                rect.y <= y && y + height <= rect.y + rect.height;
    }
}
