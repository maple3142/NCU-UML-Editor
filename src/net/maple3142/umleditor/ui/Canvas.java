package net.maple3142.umleditor.ui;

import net.maple3142.umleditor.ApplicationState;
import net.maple3142.umleditor.handler.BaseModeHandler;
import net.maple3142.umleditor.handler.HandlerFactory;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Canvas extends JPanel {
    private final static Color bgColor = new Color(38, 41, 40);
    private final ApplicationState state;
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
        state.lines.bind(val -> this.repaint());
        state.dragSelectionArea.bind(val -> this.repaint());
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(bgColor);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (var obj : state.components.get()) {
            obj.draw(g);
        }
        for (var obj : state.lines.get()) {
            obj.draw(g);
        }

        if (state.dragSelectionArea.get() != null) {
            var rect = state.dragSelectionArea.get();
            g.setColor(new Color(66, 200, 245, 64));
            g.fillRect(rect.x, rect.y, rect.width, rect.height);
        }
    }
}
