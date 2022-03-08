package net.maple3142.umleditor;

import net.maple3142.umleditor.components.BasicObject;
import net.maple3142.umleditor.components.CompositeObject;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

public class MenuBar extends JMenuBar {
    private final ApplicationState state;

    public MenuBar(ApplicationState st) {
        state = st;

        var fileMenu = new JMenu("File");
        add(fileMenu);
        var exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);
        exitItem.addActionListener(event -> {
            System.exit(0);
        });

        var editMenu = new JMenu("Edit");
        add(editMenu);
        var changeNameItem = new JMenuItem("Change object name");
        changeNameItem.setEnabled(false);
        changeNameItem.addActionListener(this::onChangeName);
        editMenu.add(changeNameItem);
        var groupItem = new JMenuItem("Group");
        groupItem.setEnabled(false);
        groupItem.addActionListener(this::onGroup);
        editMenu.add(groupItem);
        var ungroupItem = new JMenuItem("Ungroup");
        ungroupItem.setEnabled(false);
        ungroupItem.addActionListener(this::onUngroup);
        editMenu.add(ungroupItem);

        state.selections.bind(selections -> {
            changeNameItem.setEnabled(false);
            groupItem.setEnabled(false);
            ungroupItem.setEnabled(false);
            if (selections.size() == 1 && selections.get(0) instanceof BasicObject) {
                changeNameItem.setEnabled(true);
            } else if (selections.size() > 1) {
                groupItem.setEnabled(true);
            } else if (selections.size() == 1 && selections.get(0) instanceof CompositeObject) {
                ungroupItem.setEnabled(true);
            }
        });
    }

    private void onChangeName(ActionEvent event) {
        state.selections.mutate(selections -> {
            var target = (BasicObject) selections.get(0);
            var newName = JOptionPane.showInputDialog(this, "New name:", target.getName());
            if (newName != null) {
                target.setName(newName);
            }
        });
    }

    private void onGroup(ActionEvent event) {
        state.components.mutate(comps -> {
            state.selections.mutate(selections -> {
                var grouped = new CompositeObject(selections, state.depth.next());
                for (var obj : selections) {
                    obj.blur();
                    comps.remove(obj);
                }
                selections.clear();
                comps.add(grouped);
                // everything will be unselected after grouping
            });
        });
    }

    private void onUngroup(ActionEvent event) {
        state.components.mutate(comps -> {
            state.selections.mutate(selections -> {
                var grouped = (CompositeObject) selections.get(0);
                grouped.blur();
                selections.clear();
                comps.remove(grouped);
                comps.addAll(grouped.getObjs());
                // everything will be unselected after ungrouping too
            });
        });
    }
}
