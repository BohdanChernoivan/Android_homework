package com.example.dz_15.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dz_15.R;
import com.example.dz_15.dataPhoto.LinksPhoto;
import com.example.dz_15.logic.TakePhoto;

public class MainActivity extends AppCompatActivity {


    ImageView imageView;
    ImageButton imageButton;
    TextView textView;
    Button butNewCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = findViewById(R.id.imageVie3w);
        imageButton = findViewById(R.id.imageButton);
        textView = findViewById(R.id.textView2);
        butNewCat = findViewById(R.id.textView3);

        LinksPhoto linksPhoto = new LinksPhoto();
        final TakePhoto takePhoto = new TakePhoto(linksPhoto.getSfinks(), imageView);


        butNewCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto.getNextPicture();
            }
        });





    }
}
