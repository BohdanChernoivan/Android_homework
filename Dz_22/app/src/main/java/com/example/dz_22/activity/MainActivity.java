package com.example.dz_22.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dz_22.R;
import com.example.dz_22.ui.ClockFaceView;

public class MainActivity extends AppCompatActivity {

    ClockFaceView clockFaceView;
    Handler handler;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        control();

        handler = new Handler();

        drawClock();

    }

    private void control() {
        clockFaceView = findViewById(R.id.clock);
    }

    private void drawClock() {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        clockFaceView.invalidate();
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        });


        thread.start();
    }
}
