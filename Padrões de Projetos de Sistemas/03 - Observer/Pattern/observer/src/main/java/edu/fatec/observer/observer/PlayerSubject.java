package edu.fatec.observer.observer;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerSubject {

    private String name;
    private Integer life;
    private Integer mana;
    private List<GameObserver> observers;

    public void addObserver(GameObserver observer) {
        if (observers == null) {
        observers = new ArrayList<>();
        }
        observers.add(observer);
    }

    public void performAction(String action) throws InterruptedException {
        int roll = rollDice();
        String status;
    
        if ("ataque".equalsIgnoreCase(action)) {
            if (roll == 20) {
                status = "ataque crítico";
                System.out.println("ATAQUE CRÍTICO! (Dado: " + roll + ")");
                notifyObservers(status);
            } else if (roll >= 10) {
                status = "ataque com sucesso";
                System.out.println("Ataque com sucesso! (Dado: " + roll + ")");
                notifyObservers(status);
            } else {
                life -= 10;
                status = "falhou";
                System.out.println("Ataque falhou! (Dado: " + roll + ")");
                if (life <= 0) {
                    status += "derrotado";
                }
                notifyObservers(status);
            }
            

        } else if ("cura".equalsIgnoreCase(action)) {
            if (mana >= 10) {
                mana -= 10;
                if (roll >= 10) {
                    int healAmount = 20;
                    life = Math.min(life + healAmount, 100);
                    System.out.println("Vida recuperada com sucesso! (Dado: " + roll + ")");
                    System.out.println("Vida atual: " + life + " | " + "Mana restante: " + mana);
                    System.out.println("--------------------------");
                    status = "cura com sucesso";
                    Thread.sleep(1000);
                    notifyObservers(status);
                } else {
                    System.out.println("Falhou na tentativa de cura! (Dado: " + roll + ")");
                    System.out.println("--------------------------");
                    notifyObservers("cura falhou");
                    Thread.sleep(1000);
                }
            } else {
                System.out.println("Jogador " + name + " tentou curar, mas não tem mana suficiente!");
            }
        } else {
            status = "Ação desconhecida: " + action;
        }
    }

    public String checkIfDefeated() {
        if (life <= 0) {
            return "Você foi derrotado!";
        }
        return "Você ainda está de pé!";
    }

    public void notifyObservers(String status) {
        for (GameObserver observer : observers) {
            observer.update(status);
        }
    }

    public int rollDice() {
        return (int) (Math.random() * 21);
    }
}
