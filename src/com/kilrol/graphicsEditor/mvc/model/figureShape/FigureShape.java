package com.kilrol.graphicsEditor.mvc.model.figureShape;

import java.awt.*;
import java.awt.geom.Point2D;

public interface FigureShape extends Shape {
    Object clone();
    void setFrameFromDiagonal(Point2D point2D, Point2D point2D1);
    double getMinX();
    double getMinY();
    double getMaxX();
    double getMaxY();
    void setFrameFromDiagonal(double xMin, double yMin, double xMax, double yMax);
}
