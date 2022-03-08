package net.maple3142.umleditor.handler;

import net.maple3142.umleditor.ApplicationState;
import net.maple3142.umleditor.components.ConnectionDot;
import net.maple3142.umleditor.components.Line;
import net.maple3142.umleditor.components.Point2D;
import net.maple3142.umleditor.components.SimplePoint2D;

import java.awt.event.MouseEvent;
import java.util.function.BiFunction;

public class LineModeHandler extends BaseModeHandler {
    private final BiFunction<Point2D, Point2D, Line> createLine;
    private ConnectionDot start;
    private Line templine;
    public LineModeHandler(ApplicationState st, BiFunction<Point2D, Point2D, Line> lineCons) {
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
        var end = new SimplePoint2D(e.getX(), e.getY());
        state.lines.mutate(lines -> {
            lines.remove(templine);
            templine = createLine.apply(start, end);
            lines.add(templine);
        });
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (start == null) return;
        int x = e.getX();
        int y = e.getY();
        state.lines.mutate(lines -> {
            lines.remove(templine);
            templine = null;
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
