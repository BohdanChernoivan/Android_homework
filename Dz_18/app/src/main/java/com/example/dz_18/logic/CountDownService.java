package com.example.dz_18.logic;

import android.app.IntentService;
import android.content.Intent;

import com.example.dz_18.data.Counter;

public class CountDownService extends IntentService {


    public static final String COUNTER_KEY = "CounterTime";
    public static final String COUNT_DOWN_ACTION = ".com.example.dz_18.logic.CountDownService.Action";

    public CountDownService() {
        super("CountDownService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            startCountDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void startCountDown() throws InterruptedException {
        for (int i = Counter.getAnInt(); i > 1; i--) {
            Thread.sleep(500);
            Intent intent = new Intent();
            intent.setAction(COUNT_DOWN_ACTION);
            intent.putExtra(COUNTER_KEY, i);
            sendBroadcast(intent);
        }
    }
}
