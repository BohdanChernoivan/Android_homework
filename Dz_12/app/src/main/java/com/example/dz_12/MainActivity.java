package com.example.dz_12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String myString = "MY TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.name2);

        textView.setText(myString);

        final Button button = findViewById(R.id.botto2m);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(R.string.second);
            }
        });
    }
}
//    View.OnClickListener clickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textView.setText(R.string.second);
//            }
//        };
//    public void onMyButtomClick(View view) {
//        Toast.makeText(this, myString,Toast.LENGTH_SHORT).show();
//    }
