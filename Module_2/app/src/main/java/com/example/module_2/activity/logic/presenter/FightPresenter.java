package com.example.module_2.activity.logic.presenter;

import com.example.module_2.activity.data.Cat;

public class FightPresenter {

    private Fight fight;

    public FightPresenter(Fight fight) {
        this.fight = fight;
    }

    public interface Fight{

        void fightCats(Cat myCat, Cat enemyCat);

    }
}
