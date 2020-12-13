package com.kilrol.graphicsEditor.menu;

import com.kilrol.graphicsEditor.mvc.model.UndoMachine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

public class SwitchUndo extends AbstractAction implements Observer {
    public SwitchUndo(String name, Icon icon, UndoMachine machine) {
        super(name, icon);
        putValue("machine", machine);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UndoMachine m = (UndoMachine)getValue("machine");
        if (this.isEnabled()) m.unexecute();
    }

    @Override
    public void update(Observable o, Object arg) {
        UndoMachine.UndoRedoButtonState buttonState = (UndoMachine.UndoRedoButtonState) arg;
        this.setEnabled(buttonState.undo);
    }
}
