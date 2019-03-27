package com.example.module_2.activity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.module_2.R;
import com.example.module_2.activity.data.CatLinks;
import com.example.module_2.activity.logic.ArrayCats;
import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {

    ImageView imageView;
    TextView mName;
    TextView hp, dmg, def;
    ArrayCats cats;
    private Picasso picasso = Picasso.get();
    CatLinks catLinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = findViewById(R.id.imageView2);
        mName = findViewById(R.id.name);
        hp = findViewById(R.id.HealthPoint);
        dmg = findViewById(R.id.damage);
        def = findViewById(R.id.defense);

        catLinks = new CatLinks();




        Intent i = getIntent();
        String photo = i.getStringExtra("photo");
        String name = i.getStringExtra("name");
//        String number = i.getStringExtra("number");





        String namE = String.format(getString(R.string.NAME),name);
        mName.setText(namE);

        String hP = String.format(getString(R.string.HealthPoint), catLinks.getHpCat().get(name));
        hp.setText(hP);

        String dmG = String.format(getString(R.string.Damage), catLinks.getDamageCat().get(name));
        dmg.setText(dmG);

        String deF = String.format(getString(R.string.Defense), catLinks.getDefenseCat().get(name));
        def.setText(deF);


        picasso.load(photo)
                .error(R.drawable.ic_cloud_queue_black_24dp)
                .into(imageView);

    }

    protected void onClickChoose(View view) {
        switch (view.getId()) {
            case R.id.buttonChEnemy:
                Intent intent = new Intent(this, Main3Activity.class);
                startActivity(intent);

        }
    }
}
