package net.maple3142.umleditor.components;

import java.util.Comparator;

public class SelectableObjectComparator implements Comparator<SelectableObject> {
    @Override
    public int compare(SelectableObject a, SelectableObject b) {
        return a.getDepth() - b.getDepth();
    }
}
