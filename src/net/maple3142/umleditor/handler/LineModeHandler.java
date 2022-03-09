package net.maple3142.umleditor.handler;

import net.maple3142.umleditor.ApplicationState;
import net.maple3142.umleditor.components.ConnectionDot;
import net.maple3142.umleditor.components.Line;
import net.maple3142.umleditor.misc.IntPointXY;
import net.maple3142.umleditor.misc.Vector2;

import java.awt.event.MouseEvent;
import java.util.function.BiFunction;

public class LineModeHandler extends BaseModeHandler {
    private final BiFunction<IntPointXY, IntPointXY, Line> createLine;
    private ConnectionDot start;
    private Line tempLine;

    public LineModeHandler(ApplicationState st, BiFunction<IntPointXY, IntPointXY, Line> lineCons) {
        super(st);
        createLine = lineCons;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        for (var obj : state.components.get()) {
            start = obj.getClosestConnectionDot(x, y);
            if (start != null) {
                break;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (start == null) return;
        var end = new Vector2(e.getX(), e.getY());
        state.lines.mutate(lines -> {
            lines.remove(tempLine);
            tempLine = createLine.apply(start, end);
            lines.add(tempLine);
        });
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (start == null) return;
        int x = e.getX();
        int y = e.getY();
        state.lines.mutate(lines -> {
            lines.remove(tempLine);
            tempLine = null;
            for (var obj : state.components.get()) {
                var end = obj.getClosestConnectionDot(x, y);
                if (end != null && end != start) {
                    var line = createLine.apply(start, end);
                    lines.add(line);
                    break;
                }
            }
        });
    }
}
