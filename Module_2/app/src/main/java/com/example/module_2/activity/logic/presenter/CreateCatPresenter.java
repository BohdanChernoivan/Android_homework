package com.example.module_2.activity.logic.presenter;

import com.example.module_2.activity.data.Cat;

public class CreateCatPresenter {

    private ViewCat viewCat;

    public CreateCatPresenter(ViewCat viewCat) {
        this.viewCat = viewCat;
    }

    public interface ViewCat{

        void characteristicsInsert(Cat cat);
    }
}
