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
import com.example.dz_18.data.Counter;
import com.example.dz_18.logic.CountDownService;
import com.example.dz_18.logic.presenter.ContinueMainPresenter;

import static com.example.dz_18.logic.CountDownService.COUNT_DOWN_ACTION;

public class ContinueCountDown extends AppCompatActivity implements ContinueMainPresenter.ContinueView {

    Button buttonAdd;
    Button buttonIddQd;
    TextView view;

    CountDownBroadcastReceiverContinue countDownBroadcastReceiverContinue;

    ContinueMainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_count_down);

        buttonAdd = findViewById(R.id.add20);
        buttonIddQd = findViewById(R.id.iddQd);
        view = findViewById(R.id.countDownContinue);

        countDownBroadcastReceiverContinue = new CountDownBroadcastReceiverContinue();

        mainPresenter = new ContinueMainPresenter(this);

        Intent intent = new Intent(this, CountDownService.class);
        startService(intent);

        buttonAdd.setOnClickListener(this::addInt);


    }


    @Override
    public void acceptIntentService() {

    }

    @Override
    public void addInt(View view) {
        Counter.setAnInt(20);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter(COUNT_DOWN_ACTION);
        registerReceiver(countDownBroadcastReceiverContinue,filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(countDownBroadcastReceiverContinue);
    }

    class CountDownBroadcastReceiverContinue extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            int val = intent.getIntExtra("CounterTime",0);
            view.setText(getString(R.string.count_down, val));
        }
    }
}
