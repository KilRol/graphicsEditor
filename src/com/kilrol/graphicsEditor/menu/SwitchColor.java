package com.kilrol.graphicsEditor.menu;

import com.kilrol.graphicsEditor.mvc.contoller.State;

import javax.swing.*;
import java.awt.*;

public class SwitchColor implements Command {
    State state;

    public SwitchColor(State state) {
        this.state = state;
    }

    @Override
    public void execute() {
        Color c = JColorChooser.showDialog(null, "choose color", Color.BLACK);
        state.setColor(c);
    }
}
