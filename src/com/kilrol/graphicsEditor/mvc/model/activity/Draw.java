package com.kilrol.graphicsEditor.mvc.model.activity;

import com.kilrol.graphicsEditor.mvc.model.Model;
import com.kilrol.graphicsEditor.mvc.model.MyShape;

import java.awt.geom.Point2D;

public class Draw implements Activity{
    Model model;
    Point2D[] p;
    MyShape myShape;

    public Draw(Model model) {
        this.model = model;
        p = new Point2D[2];
    }

    public Draw() {
        p = new Point2D[2];
    }

    @Override
    public void getPointOne(Point2D p1){
        p[0] = p1;
        myShape =model.inintCurrentShape();
    }

    public void getPointTwo(Point2D p1){
        p[1] = p1;
        model.changeShape(p);
    }

    @Override
    public void execute() {
        model.setActiveShape(myShape);
    }

    @Override
    public void unexecute() {
        model.ctrlZ_Shape();
    }

    @Override
    public Activity clone() {
        Draw d = new Draw(model);
        d.myShape = myShape;
        d.p = p;
        return d;
    }

    @Override
    public void setModel(Model m) {
        model = m;
    }
}
