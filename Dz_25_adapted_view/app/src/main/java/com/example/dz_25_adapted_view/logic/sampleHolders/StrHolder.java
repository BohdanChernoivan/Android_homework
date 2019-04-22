package com.example.dz_25_adapted_view.logic.sampleHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dz_25_adapted_view.R;
import com.example.dz_25_adapted_view.characters.CharStrength;
import com.example.dz_25_adapted_view.logic.sampleHolders.sample.CharacterHolder;
import com.squareup.picasso.Picasso;

public class StrHolder extends CharacterHolder {

    private ImageView img;
    private TextView txt;

    public StrHolder(View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img_str_char);
        txt = itemView.findViewById(R.id.txt_str_char);
    }

    public void bind(CharStrength strength) {
        Picasso.get()
                .load(strength.getImgUrl())
                .error(R.drawable.ic_cancel_black_24dp)
                .placeholder(R.drawable.ic_file_download_black_24dp)
                .into(img);
    }
}
