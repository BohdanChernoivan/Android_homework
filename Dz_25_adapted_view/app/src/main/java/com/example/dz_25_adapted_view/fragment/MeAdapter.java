package com.example.dz_25_adapted_view.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MeAdapter extends FragmentPagerAdapter {

    public MeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return (ImageFragment.newInstance(i));
    }

    @Override
    public int getCount() {
        return 0;
    }
}
