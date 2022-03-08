package net.maple3142.umleditor.misc;

public class NameGenerator {
    private int id = 1;

    public String next() {
        return "Unnamed_" + id++;
    }
}
