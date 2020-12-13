package com.kilrol.graphicsEditor.mvc.model;

import com.kilrol.graphicsEditor.mvc.model.figureShape.FigureShape;
import com.kilrol.graphicsEditor.mvc.model.figureShape.Rectangle;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serializable;

public class MyShape implements Serializable {
    Color color;
    FigureShape shape;
    FillBehavior fb;

    public MyShape(FigureShape shape) {
        this.shape = shape;
        color = Color.BLUE;
        fb = FillBehavior.NO_FILL;
    }

    public MyShape() {
        color = Color.BLUE;
        shape = new Rectangle();
        fb =  FillBehavior.NO_FILL;;
    }

    public MyShape(Color color, FigureShape shape, FillBehavior fb) {
        this.color = color;
        this.shape = shape;
        this.fb = fb;
    }

    public void setFb(FillBehavior fb) {
        this.fb = fb;
    }

    public void setShape(FigureShape shape) {
        this.shape = shape;
    }

    public void setFrame(Point2D[] pd) {
        shape.setFrameFromDiagonal(pd[0], pd[1]);
    }

    void draw(Graphics2D g) {
        fb.draw(g,color,shape);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public MyShape.FillBehavior getFb() {
        return fb;
    }
    public boolean contains(Point2D p){
        return shape.contains(p);
    }

    public MyShape clone() {
        MyShape s = new MyShape();
        FigureShape s1 = (FigureShape) shape.clone();
        s.setColor(color);
        s.setShape(s1);
        s.fb = this.fb;
        return s;
    }

    public FigureShape getShape() {
        return shape;
    }

    /////////////////////inner enum/////////////////////////////////////

    public enum FillBehavior implements Serializable{
        FILL {
            @Override
            public void draw(Graphics2D g,  Color c, FigureShape sh) {
                Paint paint = g.getPaint();
                g.setPaint(c);
                g.fill(sh);
                g.draw(sh);
                g.setPaint(paint);
            }
        } ,
        NO_FILL {
            @Override
            public void draw(Graphics2D g, Color c, FigureShape sh) {
                Paint paint = g.getPaint();
                g.setPaint(c);
                g.draw(sh);
                g.setPaint(paint);
            }
        };
        public abstract void  draw(Graphics2D g, Color c, FigureShape sh);
    }

}
