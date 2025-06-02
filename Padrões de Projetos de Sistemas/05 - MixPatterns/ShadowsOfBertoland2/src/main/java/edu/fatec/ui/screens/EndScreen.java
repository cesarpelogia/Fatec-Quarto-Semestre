package edu.fatec.ui.screens;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import edu.fatec.ui.common.TemplateScreen;

public class EndScreen extends TemplateScreen {

    private Image backgroundImage;

    public EndScreen() {
        super("End Screen");
        
        URL imgURL = getClass().getResource("/images/scenarios/endScreenScenario.png");
        if (imgURL != null) {
            backgroundImage = new ImageIcon(imgURL).getImage();
        }

        // Painel com background customizado
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        backgroundPanel.setLayout(null);
        add(backgroundPanel);
    }
}