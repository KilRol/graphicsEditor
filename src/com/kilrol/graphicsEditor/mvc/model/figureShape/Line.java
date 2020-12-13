package com.kilrol.graphicsEditor.mvc.model.figureShape;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Line extends Line2D.Double implements FigureShape {

    @Override
    public void setFrameFromDiagonal(Point2D point2D, Point2D point2D1) {
        setLine(point2D, point2D1);
    }

    @Override
    public double getMinX() {
        return getX1();
    }

    @Override
    public double getMinY() {
        return getY1();
    }

    @Override
    public double getMaxX() {
        return getX2();
    }

    @Override
    public double getMaxY() {
        return getX2();
    }

    @Override
    public void setFrameFromDiagonal(double xMin, double yMin, double xMax, double yMax) {
        setLine(xMin, yMin, xMax, yMax);
    }
}
