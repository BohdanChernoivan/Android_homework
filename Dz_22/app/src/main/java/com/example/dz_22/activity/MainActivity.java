package com.example.dz_22.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;

import com.example.dz_22.R;
import com.example.dz_22.ui.ClockFaceView;

public class MainActivity extends AppCompatActivity {

    ClockFaceView clockFaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clockFaceView = new ClockFaceView(this);
        clockFaceView.setBackgroundColor(Color.WHITE);
        setContentView(clockFaceView);

        /*
        * x1 = (int) (x0 + (radius * Math.cos(a)));
        * y1 = (int) (y0 + (radius * Math.sin(a)));
        * */

    }
}
