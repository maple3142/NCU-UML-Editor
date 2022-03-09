package net.maple3142.umleditor.handler;

import net.maple3142.umleditor.ApplicationState;
import net.maple3142.umleditor.misc.Rectangle;

import java.awt.event.MouseEvent;
import java.util.List;

@SuppressWarnings("CodeBlock2Expr")
public class SelectModeHandler extends BaseModeHandler {
    /* Last triggering point */
    private int sx;
    private int sy;

    public SelectModeHandler(ApplicationState st) {
        super(st);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        boolean clickOnObject = false;
        for (var obj : state.components.get()) {
            if (obj.isPointInside(e.getX(), e.getY())) {
                state.selections.mutate(selections -> {
                    selections.clear();
                    selections.add(obj);
                });
                obj.focus();
                clickOnObject = true;
                break;
            }
        }
        if (clickOnObject) {
            sx = x;
            sy = y;
        } else {
            state.selections.mutate(List::clear);
            state.dragSelectionArea.set(new Rectangle(x, y, x, y));
        }

        /* blur all objects that are not current selection */
        state.components.mutate(comps -> {
            for (var obj : comps) {
                if (!state.selections.get().contains(obj)) {
                    obj.blur();
                }
            }
        });
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (state.selections.get().size() == 0) {
            var rect = state.dragSelectionArea.get();
            var newRect = new Rectangle(rect.x1, rect.y1, e.getX(), e.getY());
            state.dragSelectionArea.set(newRect);
            return;
        }
        int dx = e.getX() - sx;
        int dy = e.getY() - sy;
        state.selections.mutate(selections -> {
            for (var sel : selections) {
                sel.move(dx, dy);
            }
        });
        sx = e.getX();
        sy = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        var rect = state.dragSelectionArea.get();
        if (rect != null) {
            state.components.mutate(comps -> {
                state.selections.mutate(selections -> {
                    for (var obj : comps) {
                        if (obj.isFullyInsideRect(rect)) {
                            obj.focus();
                            selections.add(obj);
                        }
                    }
                });
            });
            state.dragSelectionArea.set(null);
        }
    }

    @Override
    public void cleanup() {
        state.components.mutate(comps -> {
            for (var obj : comps) {
                obj.blur();
            }
        });
        state.selections.mutate(List::clear);
    }
}
