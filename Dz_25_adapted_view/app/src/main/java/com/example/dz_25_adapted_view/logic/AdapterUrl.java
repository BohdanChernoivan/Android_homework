package com.example.dz_25_adapted_view.logic;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.dz_25_adapted_view.R;
import com.example.dz_25_adapted_view.logic.sampleHolders.DexHolder;
import com.example.dz_25_adapted_view.logic.sampleHolders.StringHolder;
import com.example.dz_25_adapted_view.logic.sampleHolders.sample.CharacterHolder;

import java.util.ArrayList;

public class AdapterUrl extends RecyclerView.Adapter<CharacterHolder> {

    final static int VIEW_TYPE_STR = 1;
    final static int VIEW_TYPE_DEX = 2;

    ArrayList<Character> characters = new ArrayList<>();

    @Override
    public CharacterHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            default: throw new RuntimeException("unknow type");
            case VIEW_TYPE_STR:
                return new StringHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_str, viewGroup, false));
            case VIEW_TYPE_DEX:
                return new DexHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_dex, viewGroup,false));
        }
    }

    @Override
    public void onBindViewHolder(CharacterHolder characterHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
