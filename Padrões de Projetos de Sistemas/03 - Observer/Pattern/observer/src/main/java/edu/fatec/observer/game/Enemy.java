package edu.fatec.observer.game;

import edu.fatec.observer.observer.GameObserver;
import edu.fatec.observer.observer.PlayerSubject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enemy implements GameObserver {

    private String name;
    private Integer life;
    private PlayerSubject player;

    @Override
    public String update(String status) {
        if (status.contains("ataque crítico")) {
            life -= 20;
            System.out.println(name + " sofreu um ATAQUE CRÍTICO!");
            System.out.println("\n");

        } else if (status.contains("ataque com sucesso")) {
            life -= 10;
            System.out.println(name + " foi atingido!");

        } else if (status.contains("falhou")) {
            System.out.println(name + " desviou com facilidade e contra atacou!");
            System.out.println("Você perdeu 10 de vida e agora tem " + player.getLife() + " de vida restante.");

        } else if (status.contains("cura com sucesso") || status.contains("cura falhou")) {
            System.out.println(name + " ficou irritado e atacou!");
            int roll = rollDice();
            if (roll < 10) {
                player.setLife(player.getLife() - 10);
                System.out.println(name + " atacou o jogador! Você perdeu 10 de vida.");
                System.out.println("Você agora tem " + player.getLife() + " de vida restante.");
            } else {
                System.out.println(name + " tentou atacar, mas errou!");
            
            }
        } else if (status.contains("derrotado")) {
            System.out.println(name + " foi derrotado!");
        } else {
            System.out.println("Ação desconhecida: " + status);
        }

        System.out.println(checkIfDefeated());
        System.out.println("-------------------------------");

        return "Enemy [" + name + "] processou a ação.";
    }

    public int rollDice() {
        return (int) (Math.random() * 21);
    }

    public String checkIfDefeated() {
        if (life <= 0) {
            System.out.println(name + " foi derrotado!\n" +
                               name + " diz: Te pego da próxima, herói!!");
            System.out.println("-------------------------------");
            System.out.println("Parabéns! Você venceu o jogo!");
            System.out.println("Obrigado por jogar!");
            System.out.println("Até a próxima!");
            System.out.println("-------------------------------");
            System.exit(0);
        }
        return name + " ainda está de pé com " + life + " de vida.";
    }
}