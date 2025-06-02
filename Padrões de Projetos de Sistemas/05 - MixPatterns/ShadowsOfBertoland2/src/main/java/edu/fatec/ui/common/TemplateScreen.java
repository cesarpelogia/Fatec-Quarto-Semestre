package edu.fatec.ui.common;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.fatec.ShadowsOfBertoland2.observer.ScreenEventListener;

public class TemplateScreen extends JFrame implements ScreenEventListener{

    public TemplateScreen(String title){
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1280);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new GridBagLayout());
        add(centralPanel, BorderLayout.CENTER);

    }

    protected void changeScreen(JFrame newScreen){
        dispose();
        newScreen.setVisible(true);
    }

    @Override
    public void onScreenEvent(String eventType) {

    }

}
