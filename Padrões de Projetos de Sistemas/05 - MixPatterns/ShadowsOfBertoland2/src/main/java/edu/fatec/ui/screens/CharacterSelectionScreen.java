package edu.fatec.ui.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.fatec.ShadowsOfBertoland2.core.characters.players.Dwarf;
import edu.fatec.ShadowsOfBertoland2.core.characters.players.Elf;
import edu.fatec.ShadowsOfBertoland2.core.characters.players.Warrior;
import edu.fatec.ShadowsOfBertoland2.observer.ScreenEventManager;
import edu.fatec.ui.common.GameState;
import edu.fatec.ui.common.TemplateScreen;

public class CharacterSelectionScreen extends TemplateScreen {

    private Image backgroundImage;

    public CharacterSelectionScreen() {
        super("Choose Your Character");

        URL imgURL = getClass().getResource("/images/scenarios/chooseCharacter.png");
        if (imgURL != null) {
            backgroundImage = new ImageIcon(imgURL).getImage();
        }

        // Painel com imagem de fundo
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


        ImageIcon warriorIcon = new ImageIcon(getClass().getResource("/images/characters/players/Warrior.png"));
        Image warriorImg = warriorIcon.getImage().getScaledInstance(390, 390, Image.SCALE_SMOOTH); 
        JLabel warriorLabel = new JLabel(new ImageIcon(warriorImg));
        warriorLabel.setBounds(96, 400, 390, 390);
        backgroundPanel.add(warriorLabel);
        
        JButton char1 = new JButton("Warrior");
        char1.setBounds(110, 915, 338, 94);
        char1.setFont(new Font("Arial", Font.BOLD, 32));
        char1.setForeground(Color.WHITE);
        char1.setBackground(new Color(139, 0, 0));
        char1.setFocusPainted(false);
        backgroundPanel.add(char1);
    
        ImageIcon elfIcon = new ImageIcon(getClass().getResource("/images/characters/players/Elf.png"));
        Image elfImg = elfIcon.getImage().getScaledInstance(390, 390, Image.SCALE_SMOOTH); 
        JLabel elfLabel = new JLabel(new ImageIcon(elfImg));
        elfLabel.setBounds(725, 407, 390, 390);
        backgroundPanel.add(elfLabel);

        JButton char2 = new JButton("Elf");
        char2.setBounds(730, 915, 357, 94);
        char2.setFont(new Font("Arial", Font.BOLD, 32));
        char2.setForeground(Color.WHITE);
        char2.setBackground(new Color(0, 100, 0));
        char2.setFocusPainted(false);
        backgroundPanel.add(char2);

        ImageIcon dwarfIcon = new ImageIcon(getClass().getResource("/images/characters/players/Dwarf.png"));
        Image dwarfImg = dwarfIcon.getImage().getScaledInstance(390, 390, Image.SCALE_SMOOTH); 
        JLabel dwarfLabel = new JLabel(new ImageIcon(dwarfImg));
        dwarfLabel.setBounds(1345, 430, 390, 390);
        backgroundPanel.add(dwarfLabel);

        JButton char3 = new JButton("Dwarf");
        char3.setBounds(1379, 915, 340, 94);
        char3.setFont(new Font("Arial", Font.BOLD, 32));
        char3.setForeground(Color.WHITE);
        char3.setBackground(new Color(101, 67, 33));
        char3.setFocusPainted(false);
        backgroundPanel.add(char3);

        JButton backButton = new JButton("Voltar");
        backButton.setBounds(830, 1070, 169, 47);
        backButton.setFont(backButton.getFont().deriveFont(32f));
        backButton.setForeground(java.awt.Color.WHITE);
        backButton.setBackground(new java.awt.Color(10, 30, 80));
        backButton.setFocusPainted(false);
        backgroundPanel.add(backButton);

        getContentPane().add(backgroundPanel);

        char1.addActionListener(e -> {
            GameState.setSelectedPlayer(new Warrior("Warrior"));
            ScreenEventManager.notifyEvent("CHARACTER_SELECTED");
        });
        char2.addActionListener(e -> {
            GameState.setSelectedPlayer(new Elf("Elf"));
            ScreenEventManager.notifyEvent("CHARACTER_SELECTED");
        });
        char3.addActionListener(e -> {
            GameState.setSelectedPlayer(new Dwarf("Dwarf"));
            ScreenEventManager.notifyEvent("CHARACTER_SELECTED");
        });
        backButton.addActionListener(e -> {
            ScreenEventManager.notifyEvent("BACK_TO_START");
        });
    }
}
