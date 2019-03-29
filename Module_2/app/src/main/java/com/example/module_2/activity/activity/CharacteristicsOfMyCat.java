package com.example.module_2.activity.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.module_2.R;
import com.example.module_2.activity.data.Cat;
import com.example.module_2.activity.data.CatLinks;
import com.example.module_2.activity.data.CatStorage;
import com.example.module_2.activity.logic.presenter.CreateCatPresenter;
import com.squareup.picasso.Picasso;

public class CharacteristicsOfMyCat extends AppCompatActivity implements CreateCatPresenter.ViewCat {

    ImageView imageView;
    TextView mName;
    TextView hp, dmg, def;
    private Picasso picasso = Picasso.get();
    CatLinks catLinks;

    Button button;

    CreateCatPresenter createCatPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = findViewById(R.id.imageView2);
        mName = findViewById(R.id.name);
        hp = findViewById(R.id.HealthPoint);
        dmg = findViewById(R.id.damage);
        def = findViewById(R.id.defense);

        button = findViewById(R.id.buttonChEnemy);

        createCatPresenter = new CreateCatPresenter(this);

        catLinks = new CatLinks();

        Intent i = getIntent();

        final int intExtra = i.getIntExtra("myNumber", 0);

        characteristicsInsert(CatStorage.getCatList().get(intExtra));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = createIntent(intExtra);

                startActivity(intent);

            }
        });

    }

    protected Intent createIntent(int my) {
        final Cat cat = CatStorage.getCatList().get(my);
        Intent intent = new Intent(this, ShowListEnemyCats.class);
        intent.putExtra("myNumber",  my);
        intent.putExtra("MyCat", String.valueOf(cat));
        return intent;
    }

    @Override
    public void characteristicsInsert(Cat cat) {

        Cat prototype = new Cat(cat);

        picasso.load(prototype.getImageURL())
                .error(R.drawable.ic_cloud_queue_black_24dp)
                .into(imageView);

        String sName = String.format(getString(R.string.NAME), prototype.getName());
        mName.setText(sName);

        String sHp = String.format(getString(R.string.HealthPoint), prototype.getHp());
        hp.setText(sHp);

        String sDmg = String.format(getString(R.string.Damage), prototype.getAttack());
        dmg.setText(sDmg);

        String sDef = String.format(getString(R.string.Defense), prototype.getDefense());
        def.setText(sDef);

    }
}
