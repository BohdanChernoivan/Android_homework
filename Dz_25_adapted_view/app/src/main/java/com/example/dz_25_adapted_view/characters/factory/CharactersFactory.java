package com.example.dz_25_adapted_view.characters.factory;

import com.example.dz_25_adapted_view.characters.CharDexterity;
import com.example.dz_25_adapted_view.characters.CharStrength;
import com.example.dz_25_adapted_view.characters.Character;
import com.example.dz_25_adapted_view.characters.url.CharactersURL;

import java.util.Random;

public class CharactersFactory {

    public static Character getRandomCharacter() {
        Random random = new Random();
        if(random.nextBoolean()) {
            return new CharStrength(CharactersURL.getRandomUrlSTR());
        } else
            return new CharDexterity(CharactersURL.getRandomUrlDEX());
    }
}
