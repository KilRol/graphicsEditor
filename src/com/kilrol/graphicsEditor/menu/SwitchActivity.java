package com.kilrol.graphicsEditor.menu;

import com.kilrol.graphicsEditor.mvc.contoller.State;
import com.kilrol.graphicsEditor.mvc.model.activity.Activity;

public class SwitchActivity implements Command{
    State state;
    Activity activity;

    public SwitchActivity(State state, Activity activity) {
        this.state = state;
        this.activity = activity;
    }

    @Override
    public void execute() {
        state.setActivity(activity);
    }
}
