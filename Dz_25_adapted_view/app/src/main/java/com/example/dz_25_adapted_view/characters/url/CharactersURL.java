package com.example.dz_25_adapted_view.characters.url;

import java.util.Random;

public class CharactersURL {

    private static final Random r = new Random();

    private static final String[] getSTR = {
            "https://dota2.ru/img/heroes/axe/portrait.jpg",
            "https://dota2.ru/img/heroes/bristleback/portrait.jpg",
            "https://dota2.ru/img/heroes/chaos_knight/portrait.jpg",
            "https://dota2.ru/img/heroes/clockwerk/portrait.jpg",
            "https://dota2.ru/img/heroes/lifestealer/portrait.jpg",
            "https://dota2.ru/img/heroes/sand_king/portrait.jpg",
            "https://dota2.ru/img/heroes/earthshaker/portrait.jpg"
    };

    private static final String[] getDEX = {
            "https://dota2.ru/img/heroes/anti_mage/portrait.jpg",
            "https://dota2.ru/img/heroes/drow_ranger/portrait.jpg",
            "https://dota2.ru/img/heroes/juggernaut/portrait.jpg",
            "https://dota2.ru/img/heroes/phantom_assassin/portrait.jpg",
            "https://dota2.ru/img/heroes/riki/portrait.jpg",
            "https://dota2.ru/img/heroes/medusa/portrait.jpg",
            "https://dota2.ru/img/heroes/morphling/portrait.jpg"
    };

    public static String getRandomUrlSTR() {
        return getSTR[r.nextInt(6)];
    }

    public static String getRandomUrlDEX() {
        return getDEX[r.nextInt(6)];
    }
}
