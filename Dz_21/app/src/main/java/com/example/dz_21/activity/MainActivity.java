package com.example.dz_21.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dz_21.fragments.CounterFragment;
import com.example.dz_21.R;
import com.example.dz_21.fragments.DaysOfWeekFragment;
import com.example.dz_21.fragments.RegistrationFragment;

public class MainActivity
        extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.fragmentOne:
                formForFragment(new CounterFragment());
                break;

            case R.id.fragmentTwo:
                formForFragment(new RegistrationFragment());
                break;

            case R.id.fragmentThree:
                formForFragment(new DaysOfWeekFragment());
                break;

        }
    }

    private void formForFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.search_counter, fragment)
                .commit();
    }
}
