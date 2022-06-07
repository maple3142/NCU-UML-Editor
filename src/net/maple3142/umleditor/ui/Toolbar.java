package net.maple3142.umleditor.ui;

import net.maple3142.umleditor.ApplicationState;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.Objects;

@SuppressWarnings("CodeBlock2Expr")
public class Toolbar {
    final static int numButtons = 6;
    private final JPanel panel = new JPanel();

    public Toolbar(ApplicationState state) {
        panel.setLayout(new GridLayout(numButtons, 1, 2, 2));
        for (EditorMode mode : EditorMode.values()) {
            var icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/" + mode.toString() + ".png")));
            var btn = new ToolbarButton(icon);
            panel.add(btn);
            state.currentMode.bind(newMode -> {
                if (newMode.equals(mode)) btn.setOn();
                else btn.setOff();
            });
            btn.addActionListener(event -> {
                state.currentMode.set(mode);
            });
        }
    }

    public JPanel getComponent() {
        return panel;
    }
}
