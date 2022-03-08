package net.maple3142.umleditor.components;

import net.maple3142.umleditor.Rectangle;

public interface SelectableObject extends UMLComponent {
    void move(int dx, int dy);

    void focus();

    void blur();

    ConnectionDot getClosestConnectionDot(int xx, int yy);

    boolean isPointInside(int xx, int yy);

    boolean isFullyInsideRect(Rectangle rect);

    int getLeft();

    int getRight();

    int getTop();

    int getBottom();

    int getDepth();
}
