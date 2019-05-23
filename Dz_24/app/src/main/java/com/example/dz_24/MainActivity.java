package com.example.dz_24;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Animation animation;
    Animation animationTxt;
    ImageButton imgBtmHome;
    ImageButton imgBtmFavorites;
    ImageButton imgBtmSetting;
    TextView txtViewHome;
    TextView txtViewFavorites;
    TextView txtViewSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        control();


        imgBtmHome.setOnTouchListener(this::initAnimHome);
        imgBtmFavorites.setOnTouchListener(this::initAnimFavorites);
        imgBtmSetting.setOnTouchListener(this::initAnimSetting);
    }



    private void control() {

        txtViewHome = findViewById(R.id.one_view);
        txtViewFavorites = findViewById(R.id.two_view);
        txtViewSetting = findViewById(R.id.three_view);

        imgBtmHome = findViewById(R.id.one_btm);
        imgBtmFavorites = findViewById(R.id.two_btm);
        imgBtmSetting = findViewById(R.id.three_btm);

        animation = AnimationUtils.loadAnimation(this, R.anim.decrease);
        animationTxt = AnimationUtils.loadAnimation(this, R.anim.text_anim);
    }

    private boolean initAnimHome(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            txtViewFavorites.setVisibility(View.INVISIBLE);
            txtViewSetting.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
            txtViewHome.startAnimation(animationTxt);
            txtViewHome.setVisibility(View.VISIBLE);
            imgBtmHome.startAnimation(animation);
        }
        return false;
    }

    private boolean initAnimFavorites(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            txtViewHome.setVisibility(View.INVISIBLE);
            txtViewSetting.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Favorites", Toast.LENGTH_SHORT).show();
            txtViewFavorites.startAnimation(animationTxt);
            txtViewFavorites.setVisibility(View.VISIBLE);
            imgBtmFavorites.startAnimation(animation);
        }
        return false;
    }

    private boolean initAnimSetting(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            txtViewFavorites.setVisibility(View.INVISIBLE);
            txtViewHome.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
            txtViewSetting.startAnimation(animationTxt);
            txtViewSetting.setVisibility(View.VISIBLE);
            imgBtmSetting.startAnimation(animation);

        }
        return false;
    }

}
