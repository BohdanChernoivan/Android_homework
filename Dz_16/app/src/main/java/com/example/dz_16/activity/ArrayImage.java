package com.example.dz_16.activity;


import java.util.ArrayList;

public class ArrayImage {

    private ArrayList<String> cat;

    public ArrayImage() {
        cat.add("https://www.meme-arsenal.com/memes/60233d2b82e5a4010cf050276414cd60.jpg");
        cat.add("https://avatars.mds.yandex.net/get-pdb/195449/60ee7dff-6718-476d-b224-c8d886478309/s1200?webp=false");
        cat.add("https://poroda-koshek.com/wp-content/uploads/2017/03/gimalayskaya-porodajpg.jpg");
        cat.add("https://cdn1-www.cattime.com/assets/uploads/2011/12/file_2712_scottish-fold-460x290.jpg");
    }

    public ArrayList<String> getCat() {
        return cat;
    }
}
