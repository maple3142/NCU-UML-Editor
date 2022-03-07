package net.maple3142.umleditor;

import net.maple3142.umleditor.components.UMLComponent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationState {
    public final ReactiveProperty<EditorMode> currentMode = new ReactiveProperty<>(EditorMode.SELECT);
    public final ReactiveProperty<List<UMLComponent>> components = new ReactiveProperty<>(new ArrayList<>());
    public final ReactiveProperty<Rectangle> selectedArea = new ReactiveProperty<>(null);
}
