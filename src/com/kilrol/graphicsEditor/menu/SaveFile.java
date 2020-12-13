package com.kilrol.graphicsEditor.menu;

import com.kilrol.graphicsEditor.mvc.contoller.State;
import com.kilrol.graphicsEditor.mvc.model.Model;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class SaveFile implements Command{

    State state;

    public SaveFile(State s) {
        state = s;
    }

    public void execute() {
        Model model = state.getModel();
        JFileChooser fc = new JFileChooser();

        int returnVal = fc.showSaveDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            try {
                model.save(file);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"saving error");
            }
        }

    }
}
