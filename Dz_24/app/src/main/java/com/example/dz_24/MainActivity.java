package com.example.dz_24;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ValueAnimator valueAnimator;
    ObjectAnimator objectAnimator;
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
    }

    private void initAnimHome(View view) {
        Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
        objectAnimator = ObjectAnimator.ofFloat(imgBtmHome, view.getResources().getResourceName(R.anim.decrease), 100f);
        objectAnimator.setDuration(200);
        objectAnimator.start();
    }

    private void initAnimFavorites(View view) {
        Toast.makeText(this, "Favorites", Toast.LENGTH_SHORT).show();
        valueAnimator = ValueAnimator.ofFloat(0f, 100f);
        valueAnimator.setDuration(200);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float anim = (float) animation.getAnimatedValue();
                imgBtmFavorites.setTranslationX(anim);
            }
        });
        valueAnimator.start();
    }

    private void initAnimSetting(View view) {
        Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
        valueAnimator = ValueAnimator.ofFloat(0f, 100f);
        valueAnimator.setDuration(200);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float anim = (float) animation.getAnimatedValue();
                imgBtmSetting.setScaleY(anim);
            }
        });
        valueAnimator.start();
    }

}
