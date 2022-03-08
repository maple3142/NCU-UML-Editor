package net.maple3142.umleditor.components;

@FunctionalInterface
public interface BasicObjectConstructor {
    BasicObject apply(int x, int y, int depth, String name);
}
