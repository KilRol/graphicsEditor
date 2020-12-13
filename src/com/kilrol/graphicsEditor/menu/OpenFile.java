package com.kilrol.graphicsEditor.menu;

import com.kilrol.graphicsEditor.mvc.contoller.State;
import com.kilrol.graphicsEditor.mvc.model.Model;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class OpenFile implements Command {

    State state;

    public OpenFile(State state) {
        this.state = state;
    }

    public void execute() {
        Model model= state.getModel();
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            try {
                model.open(file);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }

        }

    }
}
