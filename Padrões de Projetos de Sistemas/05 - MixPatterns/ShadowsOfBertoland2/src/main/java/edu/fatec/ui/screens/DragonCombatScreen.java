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

public class DragonCombatScreen extends TemplateScreen {

    private Image backgroundImage;
    Player selected = GameState.getSelectedPlayer();

    public DragonCombatScreen() {
        super("Dragon Combat");

        URL imgURL = getClass().getResource("/images/scenarios/dragonScenario.png");
        if (imgURL != null) {
            backgroundImage = new ImageIcon(imgURL).getImage();
        }

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

        ImageIcon dragonIcon = new ImageIcon(getClass().getResource("/images/characters/enemy/dragon.png"));
        Image dragonImg = dragonIcon.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        JLabel dragonLabel = new JLabel(new ImageIcon(dragonImg));
        dragonLabel.setBounds(850, 360, 1200, 700);
        backgroundPanel.add(dragonLabel);

        if (selected != null) {
            String imagePath = "/images/characters/players/" + selected.getClass().getSimpleName() + ".png";
            URL characterUrl = getClass().getResource(imagePath);
            if (characterUrl != null) {
                ImageIcon playerIcon = new ImageIcon(characterUrl);
                Image playerImg = playerIcon.getImage().getScaledInstance(390, 390, Image.SCALE_SMOOTH);
                JLabel playerLabel = new JLabel(new ImageIcon(playerImg));
                switch (selected.getClass().getSimpleName()) {
                    case "Warrior" -> playerLabel.setBounds(180, 600, 390, 390);
                    case "Elf" -> playerLabel.setBounds(180, 610, 390, 390);
                    case "Dwarf" -> playerLabel.setBounds(180, 640, 390, 390);
                    default -> {}
                }
                backgroundPanel.add(playerLabel);
            } else {
                System.err.println("Character image not found for: " + selected.getClass().getSimpleName());
            }
        }
        setContentPane(backgroundPanel);

        JButton backButton = new JButton("Voltar");
        backButton.setBounds(10, 10, 150, 75);
        backButton.setFont(backButton.getFont().deriveFont(32f));
        backButton.setForeground(java.awt.Color.WHITE);
        backButton.setBackground(new java.awt.Color(10, 30, 80));
        backButton.setFocusPainted(false);
        backgroundPanel.add(backButton);
        backButton.addActionListener(e -> {
            ScreenEventManager.notifyEvent("ORC_COMBAT_FINISHED");
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
            ScreenEventManager.notifyEvent("DRAGON_COMBAT_FINISHED");
        });
    }

    

}
