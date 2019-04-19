package com.example.dz_24;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Animation animation;
    ImageButton imgBtmHome;
    ImageButton imgBtmFavorites;
    ImageButton imgBtmSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        control();

        imgBtmHome.setOnClickListener(this::initAnimHome);
        imgBtmFavorites.setOnClickListener(this::initAnimFavorites);
        imgBtmSetting.setOnClickListener(this::initAnimSetting);
    }


    private void control() {
        imgBtmHome = findViewById(R.id.one_btm);
        imgBtmFavorites = findViewById(R.id.two_btm);
        imgBtmSetting = findViewById(R.id.three_btm);
        animation = AnimationUtils.loadAnimation(this, R.anim.decrease);
    }

    private void initAnimHome(View view) {
        Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
        imgBtmHome.startAnimation(animation);
    }

    private void initAnimFavorites(View view) {
        Toast.makeText(this, "Favorites", Toast.LENGTH_SHORT).show();
        imgBtmFavorites.startAnimation(animation);
    }

    private void initAnimSetting(View view) {
        Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
        imgBtmSetting.startAnimation(animation);
    }

}
