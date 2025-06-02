package edu.fatec.ShadowsOfBertoland2.core.characters.enemies;

import lombok.Data;

@Data
public class Enemy {

    private String name;
    private int health;
    private int attackPower;
    private int speed;

}
