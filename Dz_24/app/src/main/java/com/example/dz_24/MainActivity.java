package com.example.dz_24;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ValueAnimator valueAnimator;
    ImageButton imgBtm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        control();

        imgBtm.setOnClickListener(this::initAnimation);
    }


    private void control() {
        imgBtm = findViewById(R.id.one_btm);
    }

    private void initAnimation(View view) {
        valueAnimator = ValueAnimator.ofFloat(0f, 100f);
        valueAnimator.setDuration(200);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float anim = (float) animation.getAnimatedValue();
                imgBtm.setElevation(anim);
            }
        });
        valueAnimator.start();
    }

}
