package edu.fatec.ui;

import edu.fatec.ShadowsOfBertoland2.characters.players.Dwarf;
import edu.fatec.ShadowsOfBertoland2.characters.players.Elf;
import edu.fatec.ShadowsOfBertoland2.characters.players.Human;
import edu.fatec.ShadowsOfBertoland2.characters.players.Player;
import javax.swing.*;
import java.awt.*;

public class CharacterSelection extends JFrame {

    private Player selectedPlayer;

    public CharacterSelection(){
        setTitle("Selecione um Personagem");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        

        JButton elfButton = new JButton("Elfo");
        JButton dwarfButton = new JButton("Anão");
        JButton humanButton = new JButton("Homem");

        elfButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Digite o nome do Elfo:"); 
            if (name != null && !name.trim().isEmpty()){
                selectCharacter(new Elf(name));
            }
        });

        dwarfButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Digite o nome do Anão:"); 
            if (name != null && !name.trim().isEmpty()){
                selectCharacter(new Dwarf(name));
            }
        });

        humanButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Digite o nome do Humano:"); 
            if (name != null && !name.trim().isEmpty()){
                selectCharacter(new Human(name));
            }
        });

        add(elfButton);
        add(dwarfButton);
        add(humanButton);

        setVisible(true);
    }

    private void selectCharacter(Player player) {
        this.selectedPlayer = player;
        JOptionPane.showMessageDialog(this, "Você escolheu: " + player.getClass().getSimpleName());

        // Aqui você pode iniciar a próxima tela ou batalha
        dispose(); // Fecha a janela de seleção
        // new GameWindow(selectedPlayer); // Exemplo de chamada para o jogo principal
    }

    public Player getSelectedPlayer() {
        return selectedPlayer;
    }
}
