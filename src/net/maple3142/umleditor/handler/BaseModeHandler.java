package net.maple3142.umleditor.handler;

import net.maple3142.umleditor.ApplicationState;

public abstract class BaseModeHandler implements FullMouseEventListener {
    protected ApplicationState state;

    public BaseModeHandler(ApplicationState st) {
        state = st;
    }

    public void cleanup() {
    }
}
