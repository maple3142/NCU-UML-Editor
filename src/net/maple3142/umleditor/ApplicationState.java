package net.maple3142.umleditor;

import net.maple3142.umleditor.components.Line;
import net.maple3142.umleditor.components.SelectableObject;
import net.maple3142.umleditor.components.SelectableObjectComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;

public class ApplicationState {
    public final ObservableProperty<EditorMode> currentMode = new ObservableProperty<>(EditorMode.SELECT);
    public final ObservableProperty<Collection<SelectableObject>> components = new ObservableProperty<>(new PriorityQueue<>(new SelectableObjectComparator()));
    public final ObservableProperty<List<SelectableObject>> selections = new ObservableProperty<>(new ArrayList<>());
    public final ObservableProperty<List<Line>> lines = new ObservableProperty<>(new ArrayList<>());
    public final ObservableProperty<Rectangle> dragSelectionArea = new ObservableProperty<>(null);
    public final DepthManager depth = new DepthManager();
    public final NameGenerator nameGen = new NameGenerator();

    public ApplicationState() {
        selections.bind(val -> components.call());
    }
}
