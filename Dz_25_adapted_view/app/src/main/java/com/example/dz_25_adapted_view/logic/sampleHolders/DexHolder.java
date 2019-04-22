package com.example.dz_25_adapted_view.logic.sampleHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dz_25_adapted_view.R;
import com.example.dz_25_adapted_view.characters.CharDexterity;
import com.example.dz_25_adapted_view.logic.sampleHolders.sample.CharacterHolder;
import com.squareup.picasso.Picasso;

public class DexHolder extends CharacterHolder {

    private ImageView img;
    private TextView txt;

    public DexHolder(View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img_dex_char);
        txt = itemView.findViewById(R.id.txt_dex_char);
    }

    public void bind(CharDexterity dexterity) {
        Picasso.get()
                .load(dexterity.getImgUrl())
                .error(R.drawable.ic_cancel_black_24dp)
                .placeholder(R.drawable.ic_file_download_black_24dp)
                .into(img);
    }
}
