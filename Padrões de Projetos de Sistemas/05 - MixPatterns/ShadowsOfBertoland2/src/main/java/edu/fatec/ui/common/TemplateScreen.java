package edu.fatec.ui.common;

import javax.swing.JFrame;

public class TemplateScreen extends JFrame {

    public TemplateScreen(String title){
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1280);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    protected void changeScreen(JFrame newScreen){
        dispose();
        newScreen.setVisible(true);
    }

}
