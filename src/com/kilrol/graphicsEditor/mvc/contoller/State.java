package com.kilrol.graphicsEditor.mvc.contoller;

import com.kilrol.graphicsEditor.mvc.model.Model;
import com.kilrol.graphicsEditor.mvc.model.MyShape;
import com.kilrol.graphicsEditor.mvc.model.activity.Activity;
import com.kilrol.graphicsEditor.mvc.model.activity.Draw;
import com.kilrol.graphicsEditor.mvc.model.figureShape.FigureShape;

import java.awt.*;

public class State {
    Model model;
    MyShape shape;
    Color color;
    MyShape.FillBehavior fb;
    MyShape.Thickness thickness;
    FigureShape rectangularShape;
    Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
        this.activity.setModel(model);
    }

    public Activity getActivity() {
        return activity;
    }

    public State(Model model) {
        this.model = model;
        activity = new Draw(model);
    }

    public void setShape(MyShape shape) {
        this.shape = shape;
    }

    public void setColor(Color color) {
        this.color = color;
        shape.setColor(color);
        model.setSampleShape(shape);
    }

    public void setFb(MyShape.FillBehavior fb) {
        this.fb = fb;
        shape.setFb(fb);
        model.setSampleShape(shape);
    }

    public void setThickness(MyShape.Thickness thickness) {
        this.thickness = thickness;
        shape.setThickness(thickness);
        model.setSampleShape(shape);
    }

    public void setRectangularShape(FigureShape rectangularShape) {
        this.rectangularShape = rectangularShape;
        shape.setShape(rectangularShape);
        model.setSampleShape(shape);
    }

    public MyShape getShape() {
        return shape;
    }

    public Model getModel() {
        return model;
    }

}
