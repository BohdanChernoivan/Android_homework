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

    public TakePhoto(ImageView imageView, String[] pg) {
        for (String x :
                pg) {
            arrayList.add(x);
        }
        this.imageView = imageView;

        if (num <= arrayList.size()) {
            givePicture(imageView);
        } else {
            num = 0;
            givePicture(imageView);
        }
    }

    public void getNextPicture() {
        setNext();
        givePicture(this.imageView);
    }

    private void setNext() {
        num++;
        if (num > arrayList.size() - 1) {
            num = 0;
        }
    }

    public ArrayList getArrayList() {
        return arrayList;
    }

    public void givePicture(ImageView s) {
        picasso.load(arrayList.get(num).toString())
                .placeholder(R.drawable.ic_texture_black_24dp)
                .error(R.drawable.ic_crop_original_black_24dp)
                .into(s);
    }
}
