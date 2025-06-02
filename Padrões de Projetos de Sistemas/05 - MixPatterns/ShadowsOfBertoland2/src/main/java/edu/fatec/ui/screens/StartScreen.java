package edu.fatec.ui.screens;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import edu.fatec.ShadowsOfBertoland2.observer.ScreenEventManager;
import edu.fatec.ui.common.TemplateScreen;

public class StartScreen extends TemplateScreen {

    private Image backgroundImage;

    public StartScreen() {
        super("Shadows of Bertoland II - Start Screen");

        URL imgURL = getClass().getResource("/images/scenarios/inicialImage.png");
        if (imgURL != null) {
            backgroundImage = new ImageIcon(imgURL).getImage();
        }

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
        
        JButton startButton = new JButton("Start Game");
        startButton.setBounds(1350, 950, 400, 80); 
        startButton.setFont(startButton.getFont().deriveFont(32f));
        startButton.setForeground(java.awt.Color.WHITE);
        startButton.setBackground(new java.awt.Color(10, 30, 80)); // Azul bem escuro
        startButton.setFocusPainted(false);
        backgroundPanel.add(startButton);


        getContentPane().add(backgroundPanel, BorderLayout.CENTER);

        startButton.addActionListener(e -> {
            ScreenEventManager.notifyEvent("START_BUTTON_CLICKED");

        });
    }
}
