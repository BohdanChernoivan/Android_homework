package com.example.dz_16.activity;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;


import com.example.dz_16.R;

public class MainActivity extends AppCompatActivity {


//    ArrayImage arrayImage = new ArrayImage();
    ImageGridAdapter gridAdapter = new ImageGridAdapter(this);
    private Button imageButton;
    private GridView gridView;
    private static final int REQUEST_IMAGE = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.selectBtn);
        gridView = findViewById(R.id.PhoneImageGrid);


        gridView.setAdapter(gridAdapter);
        gridView.invalidateViews();


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();
            }
        });
    }

    private void showFileChooser() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        Intent intent1 = Intent.createChooser(intent, "Choose Image");
        startActivityForResult(intent1, REQUEST_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if(requestCode == REQUEST_IMAGE) {
                gridAdapter.setUri(data.getData());
            }
        }
    }
}

