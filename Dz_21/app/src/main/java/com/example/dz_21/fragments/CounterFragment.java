package com.example.dz_21.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dz_21.R;

import java.util.Locale;

public class CounterFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_counter, container, false);
        TextView textView = view.findViewById(R.id.showCounterEditText);

        counterInfinity(textView);

        return view;
    }

    private void counterInfinity(TextView textView) {
        int i = 0;
//        for (i = 0; i < 100; i++) {
//            try {
//                Thread.sleep(500);
                textView.setText(String.format(Locale.getDefault(), "%d", i));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
