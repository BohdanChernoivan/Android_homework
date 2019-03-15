package com.example.dz_13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dz_13.myHelper.Substitution;



public class MainActivity extends AppCompatActivity {

    private int[] objects = {R.drawable.billposter, R.drawable.blade, R.drawable.elementor, R.drawable.jester, R.drawable.knight, R.drawable.psykeeper, R.drawable.ranger, R.drawable.ringmaster};
    Substitution s = new Substitution();
    ImageView imageView;
    Button buttonLeft;
    Button buttonRight;
    TextView leftView;
    TextView rightView;
    private static int lView = 0;
    private static int rView = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayPicture arrayPicture = new ArrayPicture(objects);

        imageView = findViewById(R.id.imageView);
        buttonLeft = findViewById(R.id.leftButton);
        buttonRight = findViewById(R.id.rightButton);
        leftView = findViewById(R.id.imageViewL);
        rightView = findViewById(R.id.imageViewR);


        saveImage(imageView, arrayPicture);


        s.substitution(leftView, lView);
        s.substitution(rightView, rView);


        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageDrawable(getDrawable(arrayPicture.getPreviousPicture()));
                lView++;
                s.substitution(leftView, lView);
            }
        });

        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageDrawable(getDrawable(arrayPicture.getNextPicture()));
                rView++;
                s.substitution(rightView, rView);
            }
        });
    }

    protected void saveImage(ImageView imageView, ArrayPicture arrayPicture) {
        imageView.setImageDrawable(getDrawable(arrayPicture.getArrayList().get(arrayPicture.getNum()).hashCode()));
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("L", lView);
        outState.putInt("R", rView);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lView = savedInstanceState.getInt("L");
        rView = savedInstanceState.getInt("R");
    }
}