package net.maple3142.umleditor.misc;

import java.util.ArrayList;
import java.util.List;

public class ObservableProperty<T> {
    private final List<Callback<T>> callbacks = new ArrayList<>();
    private T val;

    public ObservableProperty(T v) {
        val = v;
    }

    public void call() {
        for (var cb : callbacks) {
            cb.handle(val);
        }
    }

    public void set(T v) {
        val = v;
        call();
    }

    public T get() {
        return val;
    }

    public void mutate(Callback<T> cb) {
        cb.handle(val);
        call();
    }

    public void bind(Callback<T> cb) {
        callbacks.add(cb);
        cb.handle(val);
    }

    public void unbind(Callback<T> cb) {
        callbacks.remove(cb);
    }
}
