package edu.fatec.ui.screens;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.fatec.ShadowsOfBertoland2.core.characters.players.Player;
import edu.fatec.ShadowsOfBertoland2.observer.ScreenEventManager;
import edu.fatec.ui.common.GameState;
import edu.fatec.ui.common.TemplateScreen;

public class OrcCombatScreen extends TemplateScreen {

    private Image backgroundImage;
    Player selected = GameState.getSelectedPlayer();

    public OrcCombatScreen() {
        super("Orc Combat");

        // Load the background image
        URL imgURL = getClass().getResource("/images/scenarios/orcScenario.png");
        if (imgURL != null) {
            backgroundImage = new ImageIcon(imgURL).getImage();
        }

        // Set up the background panel
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        backgroundPanel.setLayout(null);

        ImageIcon orcIcon = new ImageIcon(getClass().getResource("/images/characters/enemy/orc.png"));
        Image orcImg = orcIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        JLabel orcLabel = new JLabel(new ImageIcon(orcImg));
        orcLabel.setBounds(1275, 600, 400, 400);
        backgroundPanel.add(orcLabel);

        if (selected != null) {
            String imagePath = "/images/characters/players/" + selected.getClass().getSimpleName() + ".png";
            URL characterUrl = getClass().getResource(imagePath);
            if (characterUrl != null) {
                ImageIcon playerIcon = new ImageIcon(characterUrl);
                Image playerImg = playerIcon.getImage().getScaledInstance(390, 390, Image.SCALE_SMOOTH);
                JLabel playerLabel = new JLabel(new ImageIcon(playerImg));
                switch (selected.getClass().getSimpleName()) {
                    case "Warrior" -> playerLabel.setBounds(180, 608, 390, 390);
                    case "Elf" -> playerLabel.setBounds(180, 616, 390, 390);
                    case "Dwarf" -> playerLabel.setBounds(180, 643, 390, 390);
                    default -> {}
                }
                backgroundPanel.add(playerLabel);
            }
        }

        add(backgroundPanel);

        JButton backButton = new JButton("Voltar");
        backButton.setBounds(10, 10, 150, 75);
        backButton.setFont(backButton.getFont().deriveFont(32f));
        backButton.setForeground(java.awt.Color.WHITE);
        backButton.setBackground(new java.awt.Color(10, 30, 80));
        backButton.setFocusPainted(false);
        backgroundPanel.add(backButton);
        backButton.addActionListener(e -> {
            ScreenEventManager.notifyEvent("CHARACTER_SELECTED");
        });

        JButton nextButton = new JButton("Avançar");
        nextButton.setBounds(1700, 10, 150, 75);
        nextButton.setFont(nextButton.getFont().deriveFont(32f));
        nextButton.setForeground(java.awt.Color.WHITE);
        nextButton.setBackground(new java.awt.Color(10, 30, 80));
        nextButton.setFocusPainted(false);
        backgroundPanel.add(nextButton);
        nextButton.addActionListener(e -> {
            GameState.setSelectedPlayer(selected);
            ScreenEventManager.notifyEvent("ORC_COMBAT_FINISHED");
        });
    }

}
