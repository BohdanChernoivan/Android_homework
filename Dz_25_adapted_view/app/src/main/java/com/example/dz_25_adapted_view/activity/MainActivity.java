package com.example.dz_25_adapted_view.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.animation.Animation;

import com.example.dz_25_adapted_view.R;
import com.example.dz_25_adapted_view.characters.Character;
import com.example.dz_25_adapted_view.characters.factory.CharactersFactory;
import com.example.dz_25_adapted_view.logic.AdapterUrl;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private StaggeredGridLayoutManager mGridLayout;
    private RecyclerView recyclerView;
    private ArrayList<Character> characters;
    private AdapterUrl adapterUrl;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        control();

        for (int i = 0; i < 30; i++) {
            characters.add(CharactersFactory.getRandomCharacter());
        }


        recyclerView.setAdapter(adapterUrl);

        settingView();
    }

    private void control() {
        characters = new ArrayList<>(30);
        adapterUrl = new AdapterUrl();
        recyclerView = findViewById(R.id.recycler_view_main);
        handler = new Handler();
    }

    private void settingView() {
        recyclerView.setHasFixedSize(true);
        adapterUrl.updateList(characters);
        adapterUrl.notifyDataSetChanged();
        mGridLayout = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mGridLayout);
    }
}

/*
ViewPager pager=(ViewPager)findViewById(R.id.pager);
        pager.setAdapter(new MeAdapter(getSupportFragmentManager()));*/
