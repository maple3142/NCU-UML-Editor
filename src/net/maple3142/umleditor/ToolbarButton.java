package net.maple3142.umleditor;

import javax.swing.*;
import java.awt.*;

public class ToolbarButton extends JButton {
    private static final Color offColor = new Color(0, 0, 0);
    private static final Color onColor = new Color(50, 171, 175);
    public ToolbarButton(ImageIcon icon){
        setIcon(icon);
        setBackground(offColor);
        setFocusable(false);
        setBorderPainted(false);
        setRolloverEnabled(true);
    }

    public void setOn(){
        setBackground(onColor);
    }

    public void setOff(){
        setBackground(offColor
        );
    }
}
