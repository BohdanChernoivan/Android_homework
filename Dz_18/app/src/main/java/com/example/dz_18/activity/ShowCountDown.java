package com.example.dz_18.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dz_18.R;
import com.example.dz_18.logic.CountDownService;
import com.example.dz_18.logic.presenter.MainPresenter;

import static com.example.dz_18.logic.CountDownService.COUNT_DOWN_ACTION;

public class ShowCountDown extends AppCompatActivity implements MainPresenter.MainView {


    Button button;
    Button buttonControl;
    TextView view;

    CountDownBroadcastReceiver receiver;

    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        control();

        receiver = new CountDownBroadcastReceiver();

        mainPresenter = new MainPresenter(this);

        button.setOnClickListener(this::acceptIntentService);

        buttonControl.setOnClickListener(v ->
                startActivity(createIntent())
        );

    }

    private void control() {
        button = findViewById(R.id.startCountDown);
        buttonControl = findViewById(R.id.appearButton);
        view = findViewById(R.id.countDown);
    }



    @Override
    public void acceptIntentService(View view) {
        Intent intent = new Intent(this, CountDownService.class);
        startService(intent);
        buttonControl.setVisibility(View.VISIBLE);
    }

    @Override
    public Intent createIntent() {
        Intent newIntent = new Intent(this, ContinueCountDown.class);
        return newIntent;
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter(COUNT_DOWN_ACTION);
        registerReceiver(receiver,filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    class CountDownBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            int val = intent.getIntExtra("CounterTime", 0);
            view.setText(getString(R.string.count_down, val));
        }
    }

}
