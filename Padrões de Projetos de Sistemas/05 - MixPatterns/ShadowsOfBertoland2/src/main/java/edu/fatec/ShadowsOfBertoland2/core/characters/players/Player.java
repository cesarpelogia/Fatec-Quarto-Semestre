package edu.fatec.ShadowsOfBertoland2.core.characters.players;

import lombok.Data;

@Data
public abstract class Player {

    private String name;
    private int health;
    private int attackPower;
    private int speed;

}