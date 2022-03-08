package net.maple3142.umleditor;

import net.maple3142.umleditor.components.SelectableObject;

import java.util.ArrayList;
import java.util.List;

public class ApplicationState {
    public final ObservableProperty<EditorMode> currentMode = new ObservableProperty<>(EditorMode.SELECT);
    public final ObservableProperty<List<SelectableObject>> components = new ObservableProperty<>(new ArrayList<>());
    public final ObservableProperty<List<SelectableObject>> currentSelections = new ObservableProperty<>(new ArrayList<>());
    public final ObservableProperty<Rectangle> dragSelectionArea = new ObservableProperty<>(null);

    public ApplicationState() {
        currentSelections.bind(val -> components.call());
    }
}
