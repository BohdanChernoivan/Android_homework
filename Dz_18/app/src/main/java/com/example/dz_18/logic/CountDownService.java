package com.example.dz_18.logic;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.widget.Toast;

import com.example.dz_18.R;


public class CountDownService extends IntentService {


    public static final String COUNTER_KEY = "CounterTime";
    public static final String COUNT_DOWN_ACTION = ".com.example.dz_18.logic.CountDownService.Action";
    private static final String CHANNEL_ID = "CH_ID";
    private static final int FOREGROUND_KEY = 78;

    private PowerManager.WakeLock wakeLock;

    private static int num = 100;

    public CountDownService() {
        super("CountDownService");
        setIntentRedelivery(true);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);

        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "Myapp:Wakelock");
        wakeLock.acquire(5000);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification notification = new Notification.Builder(this, CHANNEL_ID)
                    .setContentTitle("New notification")
                    .setContentText("Surprise")
                    .setSmallIcon(R.drawable.ic_brightness_low_black_24dp)
                    .build();
            startForeground(FOREGROUND_KEY,notification);

        }
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

    @Override
    public void onDestroy() {
        super.onDestroy();

        wakeLock.release();
    }

    private void startCountDown(int val) throws InterruptedException {

        num += val;

        Thread thread = new Thread();


        new Thread() {
//
//            for (; num > 1; num--) {
//            Thread.sleep(500);
//            Intent intent = new Intent();
//            intent.setAction(COUNT_DOWN_ACTION);
//            intent.putExtra(COUNTER_KEY, num);
//            sendBroadcast(intent);
//        }

        }.start();

        while (num > 1) {
            Thread.sleep(500);
            num--;
            Intent intent = new Intent();
            intent.setAction(COUNT_DOWN_ACTION);
            intent.putExtra(COUNTER_KEY, num);
            sendBroadcast(intent);
        }

    }
}
