package net.maple3142.umleditor.handle;

import net.maple3142.umleditor.ApplicationState;
import net.maple3142.umleditor.components.BasicObject;
import net.maple3142.umleditor.components.UMLComponent;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectModeHandler extends BaseModeHandler {
    private UMLComponent selection;
    /* Last triggering point */
    private int sx;
    private int sy;

    public SelectModeHandler(ApplicationState st) {
        super(st);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        boolean clickOnObject = false;
        for (var obj : state.components.get()) {
            if (obj instanceof BasicObject) {
                if (((BasicObject) obj).checkInside(e.getX(), e.getY())) {
                    selection = obj;
                    ((BasicObject) selection).focus();
                    clickOnObject = true;
                    break;
                }
            }
        }
        if (clickOnObject) {
            sx = e.getX();
            sy = e.getY();
        } else {
            selection = null;
            state.selectedArea.set(new Rectangle(e.getX(), e.getY(), 0, 0));
        }

        /* blur all objects that are not current selection */
        state.components.mutate(comps -> {
            for (var obj : comps) {
                if (obj instanceof BasicObject && obj != selection) {
                    ((BasicObject) obj).blur();
                }
            }
        });
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (selection == null) {
            state.selectedArea.mutate(rect -> {
                rect.width = e.getX() - rect.x;
                rect.height = e.getY() - rect.y;
            });
            return;
        }
        int dx = e.getX() - sx;
        int dy = e.getY() - sy;
        if (selection instanceof BasicObject) {
            state.components.mutate(comps -> {
                ((BasicObject) selection).move(dx, dy);
            });
        }
        sx = e.getX();
        sy = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        state.selectedArea.set(null);
    }

    @Override
    public void cleanup() {
        state.components.mutate(comps -> {
            for (var obj : comps) {
                if (obj instanceof BasicObject) {
                    ((BasicObject) obj).blur();
                }
            }
            selection = null;
        });
    }
}
