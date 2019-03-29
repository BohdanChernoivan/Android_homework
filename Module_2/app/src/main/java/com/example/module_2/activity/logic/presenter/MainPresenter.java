package com.example.module_2.activity.logic.presenter;

import com.example.module_2.activity.data.Cat;
import com.example.module_2.activity.data.CatStorage;

import java.util.List;

public class MainPresenter {

    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void showCats() {

        List<Cat> cats = CatStorage.getCatList();

        view.displayCats(cats);
    }


    public interface MainView {
        void displayCats(List<Cat> cats);
    }
}
