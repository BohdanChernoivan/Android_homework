package com.example.module_2.activity.logic.presenter;


import com.example.module_2.activity.data.Cat;
import com.example.module_2.activity.logic.ParcelebleCat;

import java.util.List;

public class EnemyPresenter {

    private EView view;
    private static Cat cat;

    public EnemyPresenter(EView view) {
        this.view = view;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public interface EView {

        void displayCats(List<Cat> cats);

        List<Cat> enemyCatsList(List<Cat> cats, ParcelebleCat cat);

    }
}
