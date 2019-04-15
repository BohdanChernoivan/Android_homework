package com.example.dz_23.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.dz_23.R;

public class MainTimer extends AppCompatActivity {

    ImageButton img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        control();

        img.setOnClickListener(this::setImgBtm);
    }

    private void control() {
        img = findViewById(R.id.img_btm);
    }

    private void setImgBtm(View view) {
        Toast.makeText(this, "Time not set", Toast.LENGTH_LONG).show();
    }
}
