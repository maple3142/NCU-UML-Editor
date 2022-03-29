package net.maple3142.umleditor.misc;

public class DepthManager {
    private int current = 0;

    public int next() {
        return current++;
    }
}
