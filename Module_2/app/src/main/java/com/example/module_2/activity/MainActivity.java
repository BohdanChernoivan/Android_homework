package com.example.module_2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.module_2.R;
import com.example.module_2.activity.data.CatLinks;
import com.example.module_2.activity.logic.ArrayCats;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    LinearLayout linearLayout;
    CatLinks catLinks;
    ArrayCats cats;
    ImageView imageView;
    TextView getTextView;
    private Picasso picasso = Picasso.get();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        catLinks = new CatLinks();
        cats = new ArrayCats(catLinks.getCats());


        textView = findViewById(R.id.textCat2);

        linearLayout = findViewById(R.id.ScLayout);

        for (int i = 0; i < cats.getList().size(); i++) {


            View view = getLayoutInflater().inflate(R.layout.sketch, null);

            imageView = view.findViewById(R.id.imageEx);
            getTextView = view.findViewById(R.id.nameEx);

            picasso.load(cats.getList().get(i))
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_cloud_queue_black_24dp)
                    .into(imageView);


            getTextView.setText(catLinks.getNameCat()[i]);

            linearLayout.addView(view);


        }
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.select:
//                textView.setText("ONE");
                Int();
                break;
            case R.id.buttonCat2:
//                textView.setText("TWO");
                break;
            case R.id.buttonCat3:
//                textView.setText("THREE");
                break;
            case R.id.buttonCat4:
//                textView.setText("BYE");
                break;
            case R.id.buttonCat5:
//                textView.setText("LS");
                break;
        }

    }
    protected void Int() {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
}
