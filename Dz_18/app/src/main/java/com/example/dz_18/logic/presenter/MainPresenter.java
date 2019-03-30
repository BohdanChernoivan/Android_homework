package com.example.dz_18.logic.presenter;

import android.view.View;

public class MainPresenter {

    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public interface MainView {

        void acceptIntent(View view);

    }
}
