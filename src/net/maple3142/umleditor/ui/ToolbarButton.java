package net.maple3142.umleditor.ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class ToolbarButton extends JButton {
    private static final Color offColor = new Color(9, 10, 10);
    private static final Color onColor = new Color(8, 207, 124);

    public ToolbarButton(ImageIcon icon) {
        setIcon(icon);
        setBackground(offColor);
        setFocusable(false);
        setBorderPainted(false);
        setRolloverEnabled(true);
    }

    public void setOn() {
        setBackground(onColor);
    }

    public void setOff() {
        setBackground(offColor);
    }
}
