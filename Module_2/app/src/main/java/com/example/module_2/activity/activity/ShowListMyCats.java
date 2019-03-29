package com.example.module_2.activity.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.module_2.R;
import com.example.module_2.activity.data.Cat;
import com.example.module_2.activity.data.CatStorage;
import com.example.module_2.activity.logic.presenter.MainPresenter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShowListMyCats extends AppCompatActivity implements MainPresenter.MainView {

    TextView textView;
    LinearLayout linearLayout;

    ImageView imageView;
    TextView getTextView;

    Button button;
    MainPresenter mainPresenter;
    private Picasso picasso = Picasso.get();

    final String TAG = "MKM";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.myHpCat);

        linearLayout = findViewById(R.id.ScLayout);

        mainPresenter = new MainPresenter(this);

        displayCats(CatStorage.getCatList());

        Log.i(TAG, "onCreate: " + CatStorage.getCatList().size());

    }

    protected void createCatsList(List<Cat> cats) {


        for (int i = 0; i < cats.size(); i++) {

                View view = getLayoutInflater().inflate(R.layout.sketch, null);

                imageView = view.findViewById(R.id.imageEx);
                getTextView = view.findViewById(R.id.nameEx);
                button = view.findViewById(R.id.selectEx);

                final int finalI = i;

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = createIntent(finalI);

                        startActivity(intent);

                    }
                });

                picasso.load(cats.get(i).getImageURL())
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .error(R.drawable.ic_cloud_queue_black_24dp)
                        .into(imageView);

                getTextView.setText(cats.get(i).getName());

                linearLayout.addView(view);

        }
    }

    protected Intent createIntent(int my) {
        Intent intent = new Intent(this, CharacteristicsOfMyCat.class);
        intent.putExtra("myNumber", my);
        return intent;
    }

    @Override
    public void displayCats(List<Cat> cats) {
        createCatsList(cats);
    }
}
