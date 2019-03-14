package com.example.dz_13;

import java.util.LinkedList;

public class ArrayPicture {

    LinkedList arrayList = new LinkedList();

    public ArrayPicture(int[] pg) {
        for (int i = 0; i < pg.length; i++) {
            arrayList.add(pg[i]);
        }
    }

    public LinkedList getArrayList() {
        return arrayList;
    }
}
