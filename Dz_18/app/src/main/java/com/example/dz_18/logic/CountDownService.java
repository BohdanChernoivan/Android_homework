package com.example.dz_18.logic;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;


public class CountDownService extends IntentService {


    public static final String COUNTER_KEY = "CounterTime";
    public static final String COUNT_DOWN_ACTION = ".com.example.dz_18.logic.CountDownService.Action";
    private int num = 100;

    public CountDownService() {
        super("CountDownService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int val = intent.getIntExtra("add20val", 0);
        try {
            startCountDown(val);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service запускается", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    private void startCountDown(int val) throws InterruptedException {

        num += val;

        for (int i = num; i > 1; i--) {

            Thread.sleep(500);
            Intent intent = new Intent();
            intent.setAction(COUNT_DOWN_ACTION);
            intent.putExtra(COUNTER_KEY, i);
            sendBroadcast(intent);

        }
    }
}
