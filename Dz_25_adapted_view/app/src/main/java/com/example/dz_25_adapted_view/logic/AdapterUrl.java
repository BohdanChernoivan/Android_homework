package com.example.dz_25_adapted_view.logic;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.dz_25_adapted_view.R;
import com.example.dz_25_adapted_view.characters.CharDexterity;
import com.example.dz_25_adapted_view.characters.CharStrength;
import com.example.dz_25_adapted_view.characters.Character;
import com.example.dz_25_adapted_view.logic.sampleHolders.DexHolder;
import com.example.dz_25_adapted_view.logic.sampleHolders.StrHolder;
import com.example.dz_25_adapted_view.logic.sampleHolders.sample.CharacterHolder;

import java.util.ArrayList;
import java.util.List;

public class AdapterUrl extends RecyclerView.Adapter<CharacterHolder> {

    final static int VIEW_TYPE_STR = 1;
    final static int VIEW_TYPE_DEX = 2;

    ArrayList<Character> characters = new ArrayList<>();

    @Override
    public CharacterHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            default: throw new RuntimeException("unknow type");
            case VIEW_TYPE_STR:
                return new StrHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_str, viewGroup, false));
            case VIEW_TYPE_DEX:
                return new DexHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_dex, viewGroup,false));
        }
    }

    @Override
    public void onBindViewHolder(CharacterHolder characterHolder, int viewPosition) {
        if(characterHolder instanceof StrHolder)
            ((StrHolder) characterHolder).bind((CharStrength) characters.get(viewPosition));
        if (characterHolder instanceof DexHolder)
            ((DexHolder)characterHolder).bind((CharDexterity) characters.get(viewPosition));
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= characters.size()) throw new RuntimeException("Wrong position");
        if (characters.get(position) instanceof CharStrength) return VIEW_TYPE_STR;
        if (characters.get(position) instanceof CharDexterity) return VIEW_TYPE_DEX;
        throw new RuntimeException("unknow character");
    }

    public void updateList(List<Character> characters) {
        this.characters.clear();
        this.characters.addAll(characters);
    }
}
