package edu.fatec.ui.screens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import edu.fatec.ShadowsOfBertoland2.observer.ScreenEventManager;
import edu.fatec.ui.common.TemplateScreen;

public class WyzardScreen extends TemplateScreen {

    private Image backgroundImage;

    public WyzardScreen() {
        super("Wyzard Screen");

        URL imgURL = getClass().getResource("/images/scenarios/wyzardScenario.png");
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

        JButton backButton = new JButton("Voltar");
        backButton.setBounds(10, 10, 150, 75);
        backButton.setFont(backButton.getFont().deriveFont(32f));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(10, 30, 80));
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> ScreenEventManager.notifyEvent("VICTORY_SCREEN_FINISHED"));
        backgroundPanel.add(backButton);

        // Botão Próximo
        JButton nextButton = new JButton("Próximo");
        nextButton.setBounds(10, 100, 150, 75);
        nextButton.setFont(nextButton.getFont().deriveFont(32f));
        nextButton.setForeground(Color.WHITE);
        nextButton.setBackground(new Color(10, 30, 80));
        nextButton.setFocusPainted(false);
        nextButton.addActionListener(e -> ScreenEventManager.notifyEvent("WIZARD_SCREEN_FINISHED"));
        backgroundPanel.add(nextButton);

        add(backgroundPanel);
    }
}