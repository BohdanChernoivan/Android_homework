package com.example.module_2.activity.data;

import java.util.ArrayList;
import java.util.List;

public class CatStorage {

    private static CatLinks catLinks = new CatLinks();

    private static List<Cat> catList = new ArrayList<>();

    static {

        catList.add(new Cat("Хатико", 23, 2, 7, catLinks.getCats()[0]));
        catList.add(new Cat("Хан", 25, 2, 5, catLinks.getCats()[1]));
        catList.add(new Cat("Хайди", 27, 2, 8, catLinks.getCats()[2]));
        catList.add(new Cat("Хантер", 17, 2, 5, catLinks.getCats()[3]));
        catList.add(new Cat("Халк", 34, 2, 7, catLinks.getCats()[4]));
        catList.add(new Cat("Хэппи", 21, 2, 9, catLinks.getCats()[5]));

    }

    public static List<Cat> getCatList() {
        return catList;
    }

}
