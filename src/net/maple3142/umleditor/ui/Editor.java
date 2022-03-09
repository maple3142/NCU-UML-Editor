package net.maple3142.umleditor.ui;

import net.maple3142.umleditor.ApplicationState;
import net.maple3142.umleditor.misc.EmptyCallback;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Editor {
    final static int winWidth = 800;
    final static int winHeight = 600;
    private final JFrame window = new JFrame();

    public Editor() {
        var state = new ApplicationState();

        window.setTitle("UMLEditor");
        window.setPreferredSize(new Dimension(winWidth, winHeight));
        window.setLayout(new BorderLayout());

        window.add(new MenuBar(state).getComponent(), BorderLayout.NORTH);
        window.add(new Toolbar(state).getComponent(), BorderLayout.WEST);
        window.add(new Canvas(state), BorderLayout.CENTER);
        window.pack();
    }

    public void launch(EmptyCallback onExit) {
        window.setLocationByPlatform(true);
        window.setVisible(true);
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onExit.call();
            }
        });
    }
}
