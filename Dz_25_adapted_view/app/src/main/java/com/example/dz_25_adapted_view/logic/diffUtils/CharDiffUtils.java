package com.example.dz_25_adapted_view.logic.diffUtils;

import android.support.v7.util.DiffUtil;

import com.example.dz_25_adapted_view.characters.Character;

import java.util.List;

public class CharDiffUtils extends DiffUtil.Callback {

    List<Character> oldList;
    List<Character> newList;

    public CharDiffUtils(List<Character> oldList, List<Character> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int i, int i1) {
        return (oldList.get(i).hashCode() == newList.get(i1).hashCode());
    }

    @Override
    public boolean areContentsTheSame(int i, int i1) {
        return (oldList.get(i).equals(newList.get(i1)));
    }
}
