package net.maple3142.umleditor.handler;

import net.maple3142.umleditor.ApplicationState;
import net.maple3142.umleditor.components.BasicObjectConstructor;

import java.awt.event.MouseEvent;

public class BasicObjectModeHandler extends BaseModeHandler {
    private final BasicObjectConstructor create;

    public BasicObjectModeHandler(ApplicationState st, BasicObjectConstructor cons) {
        super(st);
        create = cons;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        state.components.mutate(cps -> {
            cps.add(create.apply(e.getX(), e.getY(), state.depth.next(), state.nameGen.next()));
        });
    }
}
