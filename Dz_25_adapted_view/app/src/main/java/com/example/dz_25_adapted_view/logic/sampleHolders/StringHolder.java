package com.example.dz_25_adapted_view.logic.sampleHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dz_25_adapted_view.R;
import com.example.dz_25_adapted_view.logic.sampleHolders.sample.CharacterHolder;

public class StringHolder extends CharacterHolder {

    private ImageView img;
    private TextView txt;

    public StringHolder(View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img_str_char);
        txt = itemView.findViewById(R.id.txt_str_char);
    }
}
