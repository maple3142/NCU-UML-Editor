package net.maple3142.umleditor;

import javax.swing.*;
import java.awt.*;

public class Editor extends JFrame {
    final static int winHeight = 120 * 6;
    final static int winWidth = 800;
    private ApplicationState state;

    public Editor() {
        state = new ApplicationState();

        setTitle("UMLEditor");
        setPreferredSize(new Dimension(winWidth, winHeight));
        setLayout(new BorderLayout());

        add(new MenuBar(state), BorderLayout.NORTH);
        add(new Toolbar(state), BorderLayout.WEST);
        add(new Canvas(state), BorderLayout.CENTER);
        pack();
    }

    public void launch() {
        setLocationByPlatform(true);
        setVisible(true);
    }
}
