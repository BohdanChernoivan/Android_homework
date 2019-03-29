package com.example.module_2.activity.data;

import java.util.Objects;

public class Cat {

    private String name;
    private int hp;
    private int defense;
    private int attack;
    private String imageURL;


    public Cat(String name, int hp, int defense, int attack, String imageURL) {
        this.name = name;
        this.hp = hp;
        this.defense = defense;
        this.attack = attack;
        this.imageURL = imageURL;
    }

    public Cat(Cat cat) {
        this.name = cat.getName();
        this.hp = cat.getHp();
        this.defense = cat.getDefense();
        this.attack = cat.getAttack();
        this.imageURL = cat.getImageURL();
    }


    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getDefense() {
        return defense;
    }

    public int getAttack() {
        return attack;
    }

    public String getImageURL() {
        return imageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return hp == cat.hp &&
                defense == cat.defense &&
                attack == cat.attack &&
                Objects.equals(name, cat.name) &&
                Objects.equals(imageURL, cat.imageURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hp, defense, attack, imageURL);
    }
}
