package com.kilrol.graphicsEditor.menu;

import com.kilrol.graphicsEditor.mvc.contoller.State;
import com.kilrol.graphicsEditor.mvc.model.MyShape;

public class SwitchThickness implements Command{
    State state;
    MyShape.Thickness thickness;

    public SwitchThickness(State state, MyShape.Thickness thickness) {
        this.state = state;
        this.thickness = thickness;
    }

    @Override
    public void execute() {
        state.setThickness(thickness);
    }
}