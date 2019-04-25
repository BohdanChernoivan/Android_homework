package com.example.dz_25_adapted_view.logic.sampleHolders;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dz_25_adapted_view.R;
import com.example.dz_25_adapted_view.characters.CharDexterity;
import com.example.dz_25_adapted_view.fragment.ImageFragment;
import com.example.dz_25_adapted_view.logic.sampleHolders.sample.CharacterHolder;
import com.squareup.picasso.Picasso;

public class DexHolder extends CharacterHolder implements View.OnClickListener {

    private ImageView img;
    private TextView txt;
    private Animation animation;
    boolean isImageScaled = false;

    public DexHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        img = itemView.findViewById(R.id.img_dex_char);
        txt = itemView.findViewById(R.id.txt_dex_char);
        animation = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.increase);
    }

    public void bind(CharDexterity dexterity) {
        Picasso.get()
                .load(dexterity.getImgUrl())
                .error(R.drawable.ic_cancel_black_24dp)
                .placeholder(R.drawable.ic_file_download_black_24dp)
                .into(img);
    }

    @Override
    public void onClick(View v) {
//        ImageFragment.newInstance("https://dota2.ru/img/heroes/chaos_knight/portrait.jpg");

        if (!isImageScaled) v.animate().scaleXBy(3f).scaleYBy(3f).setDuration(500);
        if (isImageScaled) v.animate().scaleX(1f).scaleY(1f).setDuration(500);
        isImageScaled = !isImageScaled;
        Toast.makeText(v.getContext(), "Clicked Position = " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
    }
}
