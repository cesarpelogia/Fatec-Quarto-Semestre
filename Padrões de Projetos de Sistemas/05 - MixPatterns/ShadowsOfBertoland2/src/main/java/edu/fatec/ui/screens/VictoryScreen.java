package edu.fatec.ui.screens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import edu.fatec.ShadowsOfBertoland2.core.characters.players.Player;
import edu.fatec.ShadowsOfBertoland2.observer.ScreenEventManager;
import edu.fatec.ui.common.GameState;
import edu.fatec.ui.common.TemplateScreen;

public class VictoryScreen extends TemplateScreen {

    private final Player selected = GameState.getSelectedPlayer();
    private Image backgroundImage;
    private int currentTextIndex = 0;

    private final List<String> storyTexts = Arrays.asList(
        "A batalha foi vencida!",
        "Após muito sangue ser derramado nessa terra sagrada,",
        "Bertoland será finalmente libertada!",
        "Rume ao castelo para libertar o mago!",
        "Somente ele poderá restaurar a paz e a harmonia!"
    );

    private final JLabel storyLabel = new JLabel("", SwingConstants.CENTER);

    public VictoryScreen() {
        super("Victory Screen");

        URL imgURL = getClass().getResource("/images/scenarios/victoryScenario.png");
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

        // Personagem vitorioso
        if (selected != null) {
            String imagePath = "/images/characters/players/" + selected.getClass().getSimpleName() + ".png";
            URL characterUrl = getClass().getResource(imagePath);
            if (characterUrl != null) {
                ImageIcon playerIcon = new ImageIcon(characterUrl);
                Image playerImg = playerIcon.getImage().getScaledInstance(390, 390, Image.SCALE_SMOOTH);
                JLabel playerLabel = new JLabel(new ImageIcon(playerImg));
                playerLabel.setBounds(120, 600, 390, 390);
                backgroundPanel.add(playerLabel);
            }
        }

                // Botão Voltar
        JButton backButton = new JButton("Voltar");
        backButton.setBounds(10, 10, 150, 75);
        backButton.setFont(backButton.getFont().deriveFont(32f));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(10, 30, 80));
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> ScreenEventManager.notifyEvent("ORC_COMBAT_FINISHED"));
        backgroundPanel.add(backButton);

        // Botão Próximo
        JButton nextButton = new JButton("Próximo");
        nextButton.setBounds(10, 100, 150, 75);
        nextButton.setFont(nextButton.getFont().deriveFont(32f));
        nextButton.setForeground(Color.WHITE);
        nextButton.setBackground(new Color(10, 30, 80));
        nextButton.setFocusPainted(false);
        nextButton.addActionListener(e -> ScreenEventManager.notifyEvent("VICTORY_SCREEN_FINISHED"));
        backgroundPanel.add(nextButton);

        add(backgroundPanel);
    }
}
