package com.example.module_2.activity.activity;

import android.content.Intent;
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
import com.example.module_2.activity.data.CatLinks;
import com.example.module_2.activity.data.CatStorage;
import com.example.module_2.activity.logic.ParcelebleCat;
import com.example.module_2.activity.logic.presenter.EnemyPresenter;
import com.example.module_2.activity.logic.presenter.MainPresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ShowListEnemyCats extends AppCompatActivity implements EnemyPresenter.EView{

    LinearLayout linearLayout;
    CatLinks catLinks;

    ImageView imageView;
    TextView getTextView;
    Button button;

    final String TAG = "M";


    EnemyPresenter enemyPresenter;

    private Picasso picasso = Picasso.get();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        catLinks = new CatLinks();
        linearLayout = findViewById(R.id.ScLayout);

        enemyPresenter = new EnemyPresenter(this);



        Intent intent = getIntent();

        ParcelebleCat parcelableExtra = getIntent().getParcelableExtra("MyCat");

        final int intExtra = intent.getIntExtra("myNumber", 0);

        Log.w(TAG, "onCreate: "+ intExtra);

        List<Cat> showEnemyList = enemyCatsList(CatStorage.getCatList(), parcelableExtra);

        displayCats(showEnemyList);

    }


    protected void createCatsList(List<Cat> cats) {


        for (int i = 0; i < cats.size(); i++) {

            final View view = getLayoutInflater().inflate(R.layout.sketch, null);

            imageView = view.findViewById(R.id.imageEx);
            getTextView = view.findViewById(R.id.nameEx);
            button = view.findViewById(R.id.selectEx);

            final int finalI = i;

            Intent intent = getIntent();

            final int intExtra = intent.getIntExtra("myNumber", 0);

            picasso.load(CatStorage.getCatList().get(i).getImageURL())
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_cloud_queue_black_24dp)
                    .into(imageView);


            getTextView.setText(CatStorage.getCatList().get(i).getName());

            linearLayout.addView(view);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    enemyPresenter.setCat(CatStorage.getCatList().get(finalI));

                    Intent intent1 = createIntent(intExtra,finalI);

                    startActivity(intent1);
                }
            });
        }
    }

    protected Intent createIntent(int my, int enemy) {
        Intent intent = new Intent(this, CatFight.class);

        intent.putExtra("myNumber", my);
        intent.putExtra("enemyNumber", enemy);

        return intent;
    }

    @Override
    public void displayCats(List<Cat> cats) {
        createCatsList(cats);
    }

    @Override
    public List<Cat> enemyCatsList(List<Cat> cats, ParcelebleCat deleteCat) {
        List<Cat> list = new ArrayList<>(cats);
        list.remove(deleteCat);
        return list;
    }
}