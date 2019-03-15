package com.example.dz_13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int[] objects = {R.drawable.billposter, R.drawable.blade, R.drawable.elementor, R.drawable.jester, R.drawable.knight, R.drawable.psykeeper, R.drawable.ranger, R.drawable.ringmaster};
    ImageView imageView;
    Button buttonLeft;
    Button buttonRight;
    TextView leftView;
    TextView rightView;
    static int lView = 0;
    static int rView = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayPicture arrayPicture = new ArrayPicture(objects);

        imageView = findViewById(R.id.imageView);
        imageView.setImageDrawable(getDrawable(arrayPicture.getArrayList().get(0).hashCode()));
        buttonLeft = findViewById(R.id.leftButton);
        buttonRight = findViewById(R.id.rightButton);
        leftView = findViewById(R.id.imageViewL);
        rightView = findViewById(R.id.imageViewR);


        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageDrawable(getDrawable(arrayPicture.getPreviousPicture()));
                lView++;
                leftView.setText(Integer.toString(lView));
            }
        });

        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageDrawable(getDrawable(arrayPicture.getNextPicture()));
                rView++;
                rightView.setText(Integer.toString(rView));
            }
        });
    }
}
