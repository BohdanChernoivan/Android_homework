package com.example.module_2.activity.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.module_2.R;
import com.example.module_2.activity.data.Cat;
import com.example.module_2.activity.data.CatLinks;
import com.example.module_2.activity.data.CatStorage;
import com.example.module_2.activity.logic.FightLogic;
import com.example.module_2.activity.logic.presenter.FightPresenter;
import com.squareup.picasso.Picasso;

public class CatFight extends AppCompatActivity implements FightPresenter.Fight {

    private static final String TAG = "ds";
    ImageView imageView;
    ImageView imageView2;

    TextView myCatView;
    TextView enemyCatView;

    Button button;


    private Picasso picasso = Picasso.get();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        imageView = findViewById(R.id.imageOneCat);
        imageView2 = findViewById(R.id.imageTwoCat);

        myCatView = findViewById(R.id.myHpCat);
        enemyCatView = findViewById(R.id.himHpCat);

        button = findViewById(R.id.buttonFight);


        Intent intent = getIntent();

        final int myNumber = intent.getIntExtra("myNumber", 0);
        final int enemyNumber = intent.getIntExtra("enemyNumber", 0);

        picasso.load(CatStorage.getCatList().get(myNumber).getImageURL())
                .error(R.drawable.ic_cloud_queue_black_24dp)
                .into(imageView);

        picasso.load(CatStorage.getCatList().get(enemyNumber).getImageURL())
                .error(R.drawable.ic_cloud_queue_black_24dp)
                .into(imageView2);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fightCats(CatStorage.getCatList().get(myNumber), CatStorage.getCatList().get(enemyNumber));

            }
        });

    }

    @Override
    public void fightCats(Cat my, Cat enemy) {



        final Cat myCat = new Cat(my);
        final Cat enemyCat = new Cat(enemy);

        final FightLogic takeMyDamage = new FightLogic(myCat);
        final FightLogic takeEnemyDamage = new FightLogic(enemyCat);


        Log.w(TAG, "fightCats: " + myCat.getHp() );

        Handler handler = new Handler(getBaseContext().getMainLooper());

        handler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    takeMyDamage.takeDamage(enemyCat.getAttack());
                    String sd = String.format(getString(R.string.HealthPoint), myCat.getHp());
                    myCatView.setText(sd);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        handler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    takeEnemyDamage.takeDamage(myCat.getAttack());
                    String sd = String.format(getString(R.string.HealthPoint), enemyCat.getHp());
                    enemyCatView.setText(sd);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

