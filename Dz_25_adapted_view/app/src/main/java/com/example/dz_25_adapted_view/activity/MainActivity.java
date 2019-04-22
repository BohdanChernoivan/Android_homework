package com.example.dz_25_adapted_view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.dz_25_adapted_view.R;

public class MainActivity extends AppCompatActivity {

    private StaggeredGridLayoutManager mGridLayout;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        control();

        settingView();

    }

    private void control() {
        recyclerView = findViewById(R.id.recycler_view_main);
    }

    private void settingView() {
        recyclerView.setHasFixedSize(true);
        mGridLayout = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mGridLayout);
    }

}
