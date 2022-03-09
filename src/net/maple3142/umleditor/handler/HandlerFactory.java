package net.maple3142.umleditor.handler;

import net.maple3142.umleditor.ApplicationState;
import net.maple3142.umleditor.components.AssociationLine;
import net.maple3142.umleditor.components.ClassObject;
import net.maple3142.umleditor.components.CompositionLine;
import net.maple3142.umleditor.components.GeneralizationLine;
import net.maple3142.umleditor.components.UseCaseObject;
import net.maple3142.umleditor.ui.EditorMode;

public final class HandlerFactory {
    private HandlerFactory() {
    }

    public static BaseModeHandler create(EditorMode mode, ApplicationState state) {
        return switch (mode) {
            case SELECT -> new SelectModeHandler(state);
            case ASSOCIATE -> new LineModeHandler(state, AssociationLine::new);
            case GENERAL -> new LineModeHandler(state, GeneralizationLine::new);
            case COMPOSITE -> new LineModeHandler(state, CompositionLine::new);
            case CLASS -> new BasicObjectModeHandler(state, ClassObject::new);
            case USE_CASE -> new BasicObjectModeHandler(state, UseCaseObject::new);
        };
    }
}
