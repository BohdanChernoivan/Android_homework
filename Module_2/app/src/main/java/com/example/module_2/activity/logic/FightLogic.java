package com.example.module_2.activity.logic;

import com.example.module_2.activity.data.Cat;

public class FightLogic {

    private int healthPoint;
    private int damage;
    private int defense;

    public FightLogic(Cat cat) {
        this.healthPoint = cat.getHp();
        this.damage = cat.getAttack();
        this.defense = cat.getDefense();
    }

    public int takeDamage(int dmg) {
        return healthPoint -= dmg - defense;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isAlive() {
        return healthPoint > 0;
    }
}

