package net.maple3142.umleditor;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    public MenuBar(ApplicationState state){
        var fileMenu = new JMenu("File");
        add(fileMenu);
        var exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);
        exitItem.addActionListener(event->{
            System.exit(0);
        });

        var editMenu = new JMenu("Edit");
        add(editMenu);
        var changeNameItem = new JMenuItem("Change object name");
        editMenu.add(changeNameItem);
        var groupItem = new JMenuItem("Group");
        editMenu.add(groupItem);
        var ungroupItem = new JMenuItem("Ungroup");
        editMenu.add(ungroupItem);
    }
}
