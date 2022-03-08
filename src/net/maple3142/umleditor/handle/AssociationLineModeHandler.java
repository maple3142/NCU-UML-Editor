package net.maple3142.umleditor.handle;

import net.maple3142.umleditor.ApplicationState;
import net.maple3142.umleditor.components.BasicObject;
import net.maple3142.umleditor.components.ConnectionDot;
import net.maple3142.umleditor.components.Line;

import java.awt.event.MouseEvent;

public class AssociationLineModeHandler extends BaseModeHandler {
    public AssociationLineModeHandler(ApplicationState st) {
        super(st);
    }

    private ConnectionDot startDot;

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        for (var obj : state.components.get()) {
            if (obj instanceof BasicObject) {
                if (((BasicObject) obj).isPointInside(x, y)) {
                    startDot = ((BasicObject) obj).getClosestConnectionDot(x, y);
                    System.out.println(startDot.index);
                    break;
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        state.components.mutate(comps -> {
            for (var obj : comps) {
                if (obj instanceof BasicObject) {
                    if (((BasicObject) obj).isPointInside(x, y)) {
                        var endDot = ((BasicObject) obj).getClosestConnectionDot(x, y);
                        System.out.println(endDot.index);
                        var line = new Line(startDot, endDot);
                        startDot.addLine(line);
                        break;
                    }
                }
            }
        });
    }
}
