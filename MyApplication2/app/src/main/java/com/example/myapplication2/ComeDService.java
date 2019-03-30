package com.example.myapplication2;

import android.app.IntentService;
import android.content.Intent;

public class ComeDService extends IntentService {

    public static final String COUNTER_KEY = "KEY";
    public static final String COUNT_DOWN_ACTION = ".com.example.myapplication2.ComeDService.Action";

    public ComeDService() {
        super("ComeDService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            startComeDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void startComeDown() throws InterruptedException {
        for (int i = 1000; i > 1; i--) {
            Thread.sleep(500);
            Intent intent = new Intent();
            intent.setAction(COUNT_DOWN_ACTION);
            intent.putExtra(COUNTER_KEY, i);
            sendBroadcast(intent);
        }
    }
}
