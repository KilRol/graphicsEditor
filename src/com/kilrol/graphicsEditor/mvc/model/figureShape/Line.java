package com.kilrol.graphicsEditor.mvc.model.figureShape;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Line extends Line2D.Double implements FigureShape {

    public Line() {
    }

    public Line(Point2D p1, Point2D p2) {
        super(p1,p2);
    }

    public Line(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public double getMinX() {
        return getX1();
    }

    @Override
    public double getMinY() {
        return getY1();
    }

    public double getWidth() {
        return getX2() - getX1();
    }

    public double getHeight() {
        return getY2() - getY1();
    }

    @Override
    public double getMaxX() {
        return getX1() + getWidth();
    }

    @Override
    public double getMaxY() {
        return getY1() + getHeight();
    }

    @Override
    public void setFrameFromDiagonal(double xMin, double yMin, double xMax, double yMax) {
        setLine(xMin, yMin, xMax, yMax);
    }

    @Override
    public void setFrameFromDiagonal(Point2D p1, Point2D p2) {
        setLine(p1, p2);
    }
}
