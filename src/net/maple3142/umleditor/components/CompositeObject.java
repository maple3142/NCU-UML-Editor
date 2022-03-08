package net.maple3142.umleditor.components;

import net.maple3142.umleditor.Rectangle;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CompositeObject implements SelectableObject {
    private final List<SelectableObject> objs;
    private int left, right, top, bottom;
    private final int depth;
    private boolean focused = false;

    public CompositeObject(List<SelectableObject> l, int dep) {
        depth = dep;
        objs = new ArrayList<>(l);  // copy
        updateBoundary();
    }

    private void updateBoundary() {
        left = Integer.MAX_VALUE;
        right = Integer.MIN_VALUE;
        top = Integer.MAX_VALUE;
        bottom = Integer.MIN_VALUE;
        for (var obj : objs) {
            left = Math.min(left, obj.getLeft());
            right = Math.max(right, obj.getRight());
            top = Math.min(top, obj.getTop());
            bottom = Math.max(bottom, obj.getBottom());
        }
    }

    public Collection<SelectableObject> getObjs() {
        return objs;
    }

    @Override
    public void move(int dx, int dy) {
        for (var obj : objs) {
            obj.move(dx, dy);
        }
        updateBoundary();
    }

    @Override
    public void focus() {
        for (var obj : objs) {
            obj.focus();
        }
        focused = true;
    }

    @Override
    public void blur() {
        for (var obj : objs) {
            obj.blur();
        }
        focused = false;
    }

    @Override
    public ConnectionDot getClosestConnectionDot(int xx, int yy) {
        for (var obj : objs) {
            var dot = obj.getClosestConnectionDot(xx, yy);
            if (dot != null) {
                return dot;
            }
        }
        return null;
    }

    @Override
    public boolean isPointInside(int xx, int yy) {
        for (var obj : objs) {
            if (obj.isPointInside(xx, yy)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isFullyInsideRect(Rectangle rect) {
        for (var obj : objs) {
            if (!obj.isFullyInsideRect(rect)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int getLeft() {
        return left;
    }

    @Override
    public int getRight() {
        return right;
    }

    @Override
    public int getTop() {
        return top;
    }

    @Override
    public int getBottom() {
        return bottom;
    }

    @Override
    public int getDepth() {
        return depth;
    }

    @Override
    public void draw(Graphics g) {
        for (var obj : objs) {
            obj.draw(g);
        }
        if (focused) {
            g.setColor(new Color(80, 80, 80, 64));
            g.fillRect(left, top, right - left, bottom - top);
        }
    }
}
