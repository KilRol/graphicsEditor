package com.kilrol.graphicsEditor.mvc.view;

import com.kilrol.graphicsEditor.mvc.contoller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Observable;
import java.util.Observer;

public class MyPanel extends JPanel implements Observer {
    Controller controller;

    public MyPanel(){

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0){
                controller.getPointOne( arg0.getPoint());
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent arg0) {
                controller.getPointTwo(arg0.getPoint());
            }
        });
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        controller.draw(g2);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
