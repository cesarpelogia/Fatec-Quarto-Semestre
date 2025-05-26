package edu.fatec.ui.screens;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import edu.fatec.ui.common.TemplateScreen;

public class StartScreen extends TemplateScreen {

    public StartScreen() {
        super("Shadows of Bertoland II - Start Screen");
        
        JLabel imageLabel = new JLabel(
            new ImageIcon("src/main/resources/images/inicialImage.png")
        );
        add(imageLabel);

        JButton startButton = new JButton("Start Game");
        startButton.setBounds(800, 600, 200, 50);
        add(startButton);

        startButton.addActionListener(e -> {
            CharacterSelectionScreen characterSelectionScreen = new CharacterSelectionScreen();
            changeScreen(characterSelectionScreen);
        });
    }
}
