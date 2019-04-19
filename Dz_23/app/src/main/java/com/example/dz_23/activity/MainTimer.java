package com.example.dz_23.activity;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dz_23.R;

public class MainTimer extends AppCompatActivity {

    private ImageView imgView;
    private TextView txt_View;
    private EditText editText;

    private CountDown countDown;

    private long timeElapsed;
    private TextView timeElapsedView;
    private long startTime = 300 * 1000;
    private long interval = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        control();

        setDrawable();

        if (editText.getText().toString().equals("")) {
            Toast.makeText(this, "Time not set", Toast.LENGTH_LONG).show();
        } else {
            //TODO startTime = Long.valueOf(editText.getText().toString());
        }

        countDown = new CountDown(startTime, interval);
        countDown.start();
    }

    private void control() {

        imgView = findViewById(R.id.img_view);
        editText = findViewById(R.id.edt_txt);
        txt_View = findViewById(R.id.txt_view);
        timeElapsedView = findViewById(R.id.txt_view2);
    }

    private void setDrawable() {
        imgView.setImageResource(R.drawable.view_timer);
    }


    public class CountDown extends CountDownTimer {

        public CountDown(long startTime, long interval){
            super(startTime, interval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            txt_View.setText("Time remain:" + millisUntilFinished/1000);
            timeElapsed = startTime - millisUntilFinished;
            timeElapsedView.setText("Time Elapsed: " +
                    String.valueOf(timeElapsed/1000));
        }

        @Override
        public void onFinish() {
            txt_View.setText("Time's up!");
            timeElapsedView.setText("Time Elapsed: " +
                    String.valueOf(startTime/1000));
        }
    }

}



