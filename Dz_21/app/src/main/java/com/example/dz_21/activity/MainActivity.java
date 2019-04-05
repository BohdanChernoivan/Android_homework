package com.example.dz_21.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dz_21.fragments.CounterFragment;
import com.example.dz_21.R;
import com.example.dz_21.fragments.DaysOfWeekFragment;
import com.example.dz_21.fragments.RegistrationFragment;

public class MainActivity
        extends AppCompatActivity {

    private FragmentManager fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = getSupportFragmentManager();

        if(savedInstanceState == null) {
            formForFragment(new CounterFragment());
        }

    }


    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.fragmentOne:
                replaceFragment(new CounterFragment());
                break;

            case R.id.fragmentTwo:
                replaceFragment(new RegistrationFragment());
                break;

            case R.id.fragmentThree:
                replaceFragment(new DaysOfWeekFragment());
                break;

        }
    }

    private void formForFragment(Fragment fragment) {
        this.fragment
                .beginTransaction()
                .add(R.id.search_counter, fragment)
                .commit();
    }

    private void replaceFragment(Fragment fragment) {
        this.fragment
                .beginTransaction()
                .replace(R.id.search_counter, fragment)
                .addToBackStack(null)
                .commit();
    }
}

