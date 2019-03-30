package com.example.myapplication2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.myapplication2.ComeDService.COUNT_DOWN_ACTION;

public class MainActivity extends AppCompatActivity {

    ComeDownBroadcast comeDownBroadcast = new ComeDownBroadcast();

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.start);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(this::startComD);
    }

    private void startComD(View view) {
        Intent intent = new Intent(this, ComeDService.class);
        startService(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter(COUNT_DOWN_ACTION);
        registerReceiver(comeDownBroadcast,filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(comeDownBroadcast);
    }

    class ComeDownBroadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            int val = intent.getIntExtra("KEY", 0);
            textView.setText(getString(R.string.first_screen,val));
        }
    }
}
