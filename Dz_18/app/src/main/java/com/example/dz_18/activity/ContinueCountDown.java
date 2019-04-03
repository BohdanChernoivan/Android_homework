package com.example.dz_18.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
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
import com.example.dz_18.logic.presenter.ContinueMainPresenter;

import static com.example.dz_18.logic.CountDownService.COUNT_DOWN_ACTION;

public class ContinueCountDown extends AppCompatActivity implements ContinueMainPresenter.ContinueView {

    private static final int NOTIFICATION_ID = 101;

    Button buttonAdd;
    Button buttonIddQd;
    TextView view;

    private NotificationManager notificationManager;

    CountDownBroadcastReceiverContinue countDownBroadcastReceiverContinue;

    ContinueMainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_count_down);

        control();

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        countDownBroadcastReceiverContinue = new CountDownBroadcastReceiverContinue();

        mainPresenter = new ContinueMainPresenter(this);

        Intent intent = new Intent(this, CountDownService.class);
        startService(intent);

        buttonAdd.setOnClickListener(this::addValueTwenty);

        buttonIddQd.setOnClickListener(this::showNotification);


    }


    private void control() {
        buttonAdd = findViewById(R.id.add20);
        buttonIddQd = findViewById(R.id.iddQd);
        view = findViewById(R.id.countDownContinue);
    }


    @Override
    public void showNotification(View view) {

//        Intent i = new Intent(this, CountDownService.class);

        Intent intent = new Intent(this, ContinueCountDown.class);
        PendingIntent pt = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);


        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_brightness_low_black_24dp)
//                .setLargeIcon(BitmapFactory.decodeResource(getApplication().getResources(), R.drawable.ic_brightness_low_black_24dp))
                .setTicker("new notification")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("Count Down")
                .setContentText(getString(R.string.iddQd))
                .setContentIntent(pt);


        Notification notification = builder.build();

        notificationManager.notify(NOTIFICATION_ID, notification);

//        startForegroundService(i);
    }

    @Override
    public void addValueTwenty(View view) {
        Intent i = new Intent(this, CountDownService.class);
        i.putExtra("add20val", 20);
        startService(i);
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
