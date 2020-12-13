package com.kilrol.graphicsEditor.mvc.contoller;

import com.kilrol.graphicsEditor.mvc.model.Model;
import com.kilrol.graphicsEditor.mvc.model.MyShape;
import com.kilrol.graphicsEditor.mvc.model.UndoMachine;
import com.kilrol.graphicsEditor.mvc.model.activity.Activity;
import com.kilrol.graphicsEditor.mvc.model.figureShape.Rectangle;
import com.kilrol.graphicsEditor.mvc.view.MyFrame;
import com.kilrol.graphicsEditor.mvc.view.MyPanel;

import java.awt.*;
import java.awt.geom.Point2D;

public class Controller {
    Model model;
    UndoMachine undoMachine;
    MyFrame frame;
    MyPanel panel;
    Point2D[] pd;
    State state;
    MyShape shape;
    public Controller() {
        model = new Model();
        undoMachine = new UndoMachine();
        state = new State(model);
        state.setShape(new MyShape(new Rectangle()));
        state.setColor(Color.blue);
        panel = new MyPanel();
        panel.setController(this);
        model.addObserver(panel);
        frame = new MyFrame(state,undoMachine);
        frame.setPanel(panel);
        pd = new Point2D[2];
    }
    public void getPointOne(Point2D p){
        Activity activity = state.getActivity();
        activity.getPointOne(p);
        undoMachine.add(activity.clone());

    }
    public void getPointTwo(Point2D p){
        state.getActivity().getPointTwo(p);
    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }
}
