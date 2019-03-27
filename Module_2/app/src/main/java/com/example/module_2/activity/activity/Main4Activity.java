package com.example.module_2.activity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.module_2.R;
import com.squareup.picasso.Picasso;

public class Main4Activity extends AppCompatActivity {

    ImageView imageView;
    ImageView imageView2;
    private Picasso picasso = Picasso.get();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        imageView = findViewById(R.id.imageOneCat);
        imageView2 = findViewById(R.id.imageTwoCat);


        Intent intent = getIntent();
        String photo = intent.getStringExtra("photo");
        String enemyPhoto = intent.getStringExtra("enemyPhoto");
//        String name = intent.getStringExtra("name");


        picasso.load(photo)
                .error(R.drawable.ic_cloud_queue_black_24dp)
                .into(imageView);

        picasso.load(enemyPhoto)
                .error(R.drawable.ic_cloud_queue_black_24dp)
                .into(imageView2);
    }
}
