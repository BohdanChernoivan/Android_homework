package com.example.dz_13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {


    Button buttonLeft;
    Button buttonRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int[] objects = {R.drawable.billposter, R.drawable.blade, R.drawable.elementor, R.drawable.jester, R.drawable.knight, R.drawable.psykeeper, R.drawable.ranger, R.drawable.ringmaster};

        final ArrayPicture arrayPicture = new ArrayPicture(objects);

        final ImageView imageView = findViewById(R.id.imageView);
        buttonLeft = findViewById(R.id.leftButton);
        buttonRight = findViewById(R.id.rightButton);

        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageDrawable(getDrawable(arrayPicture.getArrayList().getFirst().hashCode()));
            }
        });

        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageDrawable(getDrawable(arrayPicture.getArrayList().getLast().hashCode()));
            }
        });
    }
}
