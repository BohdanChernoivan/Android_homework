package com.example.dz_15.logic;


import android.widget.ImageView;

import com.example.dz_15.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TakePhoto {

    private Picasso picasso = Picasso.get();
    private ImageView imageView;
    private ArrayList arrayList = new ArrayList();
    private static int num = 0;

    public TakePhoto(String[] pg, ImageView imageView) {
        for (String x :
                pg) {
            arrayList.add(x);
        }
        this.imageView = imageView;
        picasso.load(arrayList.get(num).toString())
        .into(imageView);
    }

    public void getNextPicture() {
        setNext();
        picasso.load(arrayList.get(num).toString())
                .placeholder(R.drawable.ic_texture_black_24dp)
                .error(R.drawable.ic_screen_lock_rotation_black_24dp)
                .into(imageView);
    }

    private void setNext() {
        num++;
        if (num > arrayList.size() - 1) {
            num = 0;
        }
    }

    public static int getNum() {
        return num;
    }

    public ArrayList getArrayList() {
        return arrayList;
    }

}
