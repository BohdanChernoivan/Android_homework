package com.example.module_2.activity.logic;

import java.util.ArrayList;

public class ArrayCats {

    private ArrayList<String> listC = new ArrayList<>();

    public ArrayCats(String[] list) {
        for (String x:list) {
            listC.add(x);
        }
    }

    public ArrayList<String> getList() {
        return listC;
    }
}
