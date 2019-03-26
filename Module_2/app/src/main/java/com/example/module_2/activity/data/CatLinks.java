package com.example.module_2.activity.data;


import java.util.HashMap;
import java.util.Map;

public class CatLinks {

    private static String[] cats = {"https://www.meme-arsenal.com/memes/63515e7f01790e5fcd962ca7075482d3.jpg", "https://coubsecure-s.akamaihd.net/get/b81/p/coub/simple/cw_timeline_pic/6d78c30e8cc/7341273ad149299c2a7e1/med_1528394199_image.jpg", "https://pbs.twimg.com/media/C_UWZQOXcAIY_3a.jpg:large", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRkvtaNAdIG1A4J4ZdTI0LhBOEN8hayDKTVDPNmUvF7oALuwPJm", "https://ic.pics.livejournal.com/kot_de_azur/31835946/1463243/1463243_900.jpg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGJ9P3RuG8ef93F8n7sv-1F3i9d9Y55oGcx7XD7sBrhWZBauJb"};
    private String[] nameCat = {"Хатико", "Хан", "Хайди", "Хантер", "Халк", "Хэппи"};
    private Map<String,Integer> hpCat = new HashMap<>();
    private Map<String, Integer> damageCat = new HashMap<>();
    private Map<String, Double> defenseCat = new HashMap<>();

    public Map<String, Integer> getHpCat() {
        return hpCat;
    }

    public CatLinks() {
        hpCat.put("Хатико", 23);
        hpCat.put("Хан", 25);
        hpCat.put("Хайди", 27);
        hpCat.put("Хантер", 17);
        hpCat.put("Халк", 34);
        hpCat.put("Хэппи", 21);

        damageCat.put("Хатико", 7);
        damageCat.put("Хан", 6);
        damageCat.put("Хайди", 6);
        damageCat.put("Хантер", 9);
        damageCat.put("Халк", 5);
        damageCat.put("Хэппи", 8);

        defenseCat.put("Хатико", 0.4);
        defenseCat.put("Хан", 0.4);
        defenseCat.put("Хайди", 0.3);
        defenseCat.put("Хантер", 0.6);
        defenseCat.put("Халк", 0.3);
        defenseCat.put("Хэппи", 0.5);
    }

    public Map<String, Integer> getDamageCat() {
        return damageCat;
    }

    public Map<String, Double> getDefenseCat() {
        return defenseCat;
    }

    public String[] getCats() {
        return cats;
    }

    public String[] getNameCat() {
        return nameCat;
    }
}
