package com.example.dz_25_adapted_view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dz_25_adapted_view.R;
import com.squareup.picasso.Picasso;


public class ImageFragment extends Fragment {

    private String page;

    public static ImageFragment newInstance(String page) {
        ImageFragment fragment = new ImageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("newPage", page);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getString("newPage");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);

//        ViewPager viewPager = view.findViewById(R.id.pager);

        ImageView imageView = view.findViewById(R.id.sPage);

        Picasso.get()
                .load(page)
                .into(imageView);

        return view;
    }
}
