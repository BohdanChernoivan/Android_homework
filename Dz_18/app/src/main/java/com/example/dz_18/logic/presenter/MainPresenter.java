package com.example.dz_18.logic.presenter;

import android.content.Intent;
import android.view.View;

public class MainPresenter {

    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public interface MainView {

        void acceptIntentService(View view);

        Intent createIntent();

    }
}
