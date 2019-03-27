package com.example.module_2.activity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.module_2.R;
import com.example.module_2.activity.data.CatLinks;
import com.squareup.picasso.Picasso;

public class Main4Activity extends AppCompatActivity {

    ImageView imageView;
    ImageView imageView2;
    private Picasso picasso = Picasso.get();

    TextView textView;

    CatLinks links = new CatLinks();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        imageView = findViewById(R.id.imageOneCat);
        imageView2 = findViewById(R.id.imageTwoCat);

        textView = findViewById(R.id.TEST);


        Intent intent = getIntent();
        String photo = intent.getStringExtra("photo");
        String myCatName = intent.getStringExtra("myName");

        String enemyPhoto = intent.getStringExtra("photoEnemy");

//        String name = intent.getStringExtra("name");



        picasso.load(enemyPhoto)
                .error(R.drawable.ic_cloud_queue_black_24dp)
                .into(imageView);

        picasso.load(photo)
                .error(R.drawable.ic_cloud_queue_black_24dp)
                .into(imageView2);


        String myHP = String.format("%1$d", links.getHpCat().get(myCatName));

//    Integer myHP = links.getHpCat().get(myCatName);

    textView.setText(myHP);

    }

    protected void dd() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
