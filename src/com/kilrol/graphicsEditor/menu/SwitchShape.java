package com.kilrol.graphicsEditor.menu;

import com.kilrol.graphicsEditor.mvc.contoller.State;
import com.kilrol.graphicsEditor.mvc.model.figureShape.FigureShape;

public class SwitchShape implements Command{
    State state;
    FigureShape rs;

    public SwitchShape(State state, FigureShape rs) {
        this.state = state;
        this.rs = rs;
    }

    @Override
    public void execute() {
        state.setRectangularShape(rs);
    }
}
