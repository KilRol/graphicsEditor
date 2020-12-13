package com.kilrol.graphicsEditor.menu;

import com.kilrol.graphicsEditor.mvc.contoller.State;
import com.kilrol.graphicsEditor.mvc.model.MyShape;

public class SwitchFill implements Command{
    State state;
    MyShape.FillBehavior fb;

    public SwitchFill(State state, MyShape.FillBehavior fb) {
        this.state = state;
        this.fb = fb;
    }

    @Override
    public void execute() {
        state.setFb(fb);
    }
}
