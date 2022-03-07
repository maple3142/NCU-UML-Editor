package net.maple3142.umleditor.handle;

import net.maple3142.umleditor.ApplicationState;
import net.maple3142.umleditor.EditorMode;

public final class HandlerFactory {
    public static BaseModeHandler create(EditorMode mode, ApplicationState state) {
        switch (mode) {
            case SELECT:
                return new SelectModeHandler(state);
            case ASSOCIATE:
                return new AssociationLineModeHandler(state);
            case CLASS:
                return new ClassModeHandler(state);
        }
        return null;
        // throw new IllegalArgumentException("not implemented");
    }
}
