package com.kilrol.graphicsEditor.mvc.view;

import com.kilrol.graphicsEditor.menu.*;
import com.kilrol.graphicsEditor.mvc.contoller.State;
import com.kilrol.graphicsEditor.mvc.model.MyShape;
import com.kilrol.graphicsEditor.mvc.model.UndoMachine;
import com.kilrol.graphicsEditor.mvc.model.activity.Draw;
import com.kilrol.graphicsEditor.mvc.model.activity.Move;
import com.kilrol.graphicsEditor.mvc.model.figureShape.Ellipse;
import com.kilrol.graphicsEditor.mvc.model.figureShape.Line;
import com.kilrol.graphicsEditor.mvc.model.figureShape.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyFrame extends JFrame {
    MyPanel panel;
    State state;
    UndoMachine undoMachine;

    public MyFrame(State state, UndoMachine machine) {
        this.state = state;
        this.undoMachine = machine;

        Action openAction = new SwitchState("Открыть", new ImageIcon("Icons/open.png"),
                new OpenFile(state));
        Action saveAction = new SwitchState("Сохранить", new ImageIcon("Icons/save.png"),
                new SaveFile(state));
        Action rectangleAction = new SwitchState("Прямоугольник", new ImageIcon("Icons/rectangle.png"),
                new SwitchShape(state, new Rectangle()));
        Action ellipseAction = new SwitchState("Овал", new ImageIcon("Icons/ellipse.png"),
                new SwitchShape(state, new Ellipse()));
        Action lineAction = new SwitchState("Линия", new ImageIcon("Icons/line.png"),
                new SwitchShape(state, new Line()));
        Action noFillAction = new SwitchState("Без заливки", new ImageIcon("Icons/empty.png"),
                new SwitchFill(state, MyShape.FillBehavior.NO_FILL));
        Action fillAction = new SwitchState("Заливка", new ImageIcon("Icons/full.png"),
                new SwitchFill(state, MyShape.FillBehavior.FILL));
        Action drawModeAction = new SwitchState("Режим рисования", new ImageIcon("Icons/pencil.png"),
                new SwitchActivity(state, new Draw()));
        Action moveModeAction = new SwitchState("Режим перемещения", new ImageIcon("Icons/move.png"),
                new SwitchActivity(state, new Move()));
        Action undoAction = new SwitchUndo("Отменить",new ImageIcon("Icons/undo.png"),undoMachine);
        Action redoAction = new SwitchRedo("Повторить",new ImageIcon("Icons/redo.png"),undoMachine);
        Action chooseColorAction = new SwitchState("Палитра", new ImageIcon("Icons/palette.png"),
                new SwitchColor(state));

        JMenuBar bar;
        bar = new JMenuBar();
        this.setJMenuBar(bar);
        ArrayList<Action> menuItems = new ArrayList<>();
        menuItems.add(openAction);
        menuItems.add(saveAction);
        menuItems.add(rectangleAction);
        menuItems.add(ellipseAction);
        menuItems.add(lineAction);
        menuItems.add(noFillAction);
        menuItems.add(fillAction);
        menuItems.add(drawModeAction);
        menuItems.add(moveModeAction);
        menuItems.add(undoAction);
        menuItems.add(redoAction);
        menuItems.add(chooseColorAction);

        undoMachine.addObserver((SwitchUndo)menuItems.get(menuItems.size()-3));
        undoMachine.addObserver((SwitchRedo)menuItems.get(menuItems.size()-2));
        undoMachine.notifyMenu();

        JMenu fileMenu = new JMenu("Файл");
        fileMenu.add(openAction);
        fileMenu.add(saveAction);
        JMenu figureMenu = new JMenu("Фигура");
        figureMenu.add(lineAction);
        figureMenu.add(rectangleAction);
        figureMenu.add(ellipseAction);
        JMenu fillMenu = new JMenu("Заливка");
        fillMenu.add(fillAction);
        fillMenu.add(noFillAction);
        JMenu modeMenu = new JMenu("Режим");
        modeMenu.add(drawModeAction);
        modeMenu.add(moveModeAction);
        JMenu undoRedoMenu = new JMenu("Отменить/Повторить");
        undoRedoMenu.add(undoAction);
        undoRedoMenu.add(redoAction);
        JMenu chooseColorMenu = new JMenu("Выбор цвета");
        chooseColorMenu.add(chooseColorAction);

        ArrayList<JMenu> menus = new ArrayList<>();
        menus.add(fileMenu);
        menus.add(figureMenu);
        menus.add(fillMenu);
        menus.add(modeMenu);
        menus.add(undoRedoMenu);
        menus.add(chooseColorMenu);

        for (JMenu m : menus) {
            bar.add(m);
        }

        JToolBar toolBar = new JToolBar();
        for (Action x : menuItems) {
            toolBar.add(x);
        }

        toolBar.setOrientation(SwingConstants.VERTICAL);

        add(toolBar, BorderLayout.WEST);

        /////////////////////////////////////////////////////////////////
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        setVisible(true);
    }

    public void setPanel(MyPanel panel) {
        this.panel = panel;
        add(panel);
    }
}
