package com.example.dz_22.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

    }
}
