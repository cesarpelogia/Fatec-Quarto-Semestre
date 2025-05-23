package edu.fatec.ui;

import javax.swing.*;
import java.awt.*;

public class GameStartScreen extends JFrame {

    public GameStartScreen() {
        setTitle("Shadows of Bertoland 2");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel com imagem de fundo
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("src/main/resources/images/inicialImage.png");
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);

        // Botão
        JButton startButton = new JButton("Iniciar Jogo");
        int buttonWidth = 220;
        int buttonHeight = 60;
        int buttonX = 720;
        int buttonY = 720;
        startButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);

        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.setBackground(new Color(0, 0, 0, 180));
        startButton.setForeground(Color.WHITE);

        startButton.addActionListener(e -> {
            dispose();
            new CharacterSelection();
        });

        backgroundPanel.add(startButton);

        setContentPane(backgroundPanel);
        setResizable(false);
        setVisible(true);
    }
}