package net.maple3142.umleditor.misc;

@FunctionalInterface
public interface Callback<T> {
    void call(T val);
}
