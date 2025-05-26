package edu.fatec.ui.screens;

import javax.swing.JButton;

import edu.fatec.ui.common.TemplateScreen;

public class CharacterSelectionScreen extends TemplateScreen {

    public CharacterSelectionScreen() {
        super("Choose Your Character");

        JButton char1 = new JButton("Warrior");
        char1.setBounds(400, 500, 150, 50);
        add(char1);

        JButton char2 = new JButton("Mage");
        char2.setBounds(800, 500, 150, 50);
        add(char2);

        JButton char3 = new JButton("Rogue");
        char3.setBounds(1200, 500, 150, 50);
        add(char3);

    //     char1.addActionListener(e -> startGame("Warrior"));
    //     char2.addActionListener(e -> startGame("Mage"));
    //     char3.addActionListener(e -> startGame("Rogue"));
    // }

    // private void startGame(String character) {
    //     CombatScreen combat = new CombatScreen(character);
    //     changeScreen(combat);
    }
}
