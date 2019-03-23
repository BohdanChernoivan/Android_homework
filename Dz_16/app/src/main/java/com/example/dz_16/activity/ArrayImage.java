package com.example.dz_16.activity;


import android.net.Uri;

import java.util.ArrayList;

public class ArrayImage {

    private Uri uri;

    private static ArrayList<Uri> arrayList = new ArrayList<>();

    public void insert(Uri addS) {
        uri = addS;
        arrayList.add(addS);
    }

    public Uri getUri() {
        return uri;
    }

    public ArrayList<Uri> getArrayList() {
        return arrayList;
    }
}
