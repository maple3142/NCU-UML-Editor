package net.maple3142.umleditor.handle;

import net.maple3142.umleditor.ApplicationState;
import net.maple3142.umleditor.components.ClassObject;

import java.awt.event.MouseEvent;

public class ClassModeHandler extends BaseModeHandler {
    public ClassModeHandler(ApplicationState st) {
        super(st);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        state.components.mutate(cps -> {
            cps.add(new ClassObject(e.getX(), e.getY()));
        });
    }
}
