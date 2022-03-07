package net.maple3142.umleditor;

import net.maple3142.umleditor.components.ClassObject;
import net.maple3142.umleditor.handle.BaseModeHandler;
import net.maple3142.umleditor.handle.FullMouseEventListener;
import net.maple3142.umleditor.handle.HandlerFactory;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    private final static Color bgColor = new Color(35, 37, 37);
    private ApplicationState state;
    private BaseModeHandler oldHandler = null;

    public Canvas(ApplicationState st) {
        state = st;
        state.currentMode.bind(newMode -> {
            if (oldHandler != null) {
                oldHandler.cleanup();
            }
            removeMouseListener(oldHandler);
            removeMouseMotionListener(oldHandler);
            var newHandler = HandlerFactory.create(newMode, state);
            addMouseListener(newHandler);
            addMouseMotionListener(newHandler);
            oldHandler = newHandler;
        });
        state.components.bind(val -> this.repaint());
        state.selectedArea.bind(val -> this.repaint());
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(bgColor);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (var obj : state.components.get()) {
            obj.draw(g);
        }

        if (state.selectedArea.get() != null) {
            var rect = state.selectedArea.get();
            g.setColor(new Color(66, 200, 245, 64));
            g.fillRect(rect.x, rect.y, rect.width, rect.height);
        }
    }
}
