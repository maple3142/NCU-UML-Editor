package net.maple3142.umleditor;

import net.maple3142.umleditor.ui.Editor;

public class Entrypoint {
    public static void main(String[] args) {
        new Editor().launch(() -> System.exit(0));
    }
}
