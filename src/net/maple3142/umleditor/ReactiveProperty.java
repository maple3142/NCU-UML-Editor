package net.maple3142.umleditor;

import java.util.ArrayList;
import java.util.List;

public class ReactiveProperty<T> {
    private final List<Callback<T>> listeners = new ArrayList<>();
    private T val;

    public ReactiveProperty(T v) {
        val = v;
    }

    public void sendEvents() {
        for (var cb : listeners) {
            cb.handle(val);
        }
    }

    public void set(T v) {
        val = v;
        sendEvents();
    }

    public T get() {
        return val;
    }

    public void mutate(Callback<T> cb) {
        cb.handle(val);
        sendEvents();
    }

    public void bind(Callback<T> cb) {
        listeners.add(cb);
        cb.handle(val);
    }

    public void unbind(Callback<T> cb) {
        listeners.remove(cb);
    }
}
