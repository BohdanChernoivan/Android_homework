package com.example.dz_23.activity;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dz_23.R;

public class MainTimer extends AppCompatActivity {
    ImageButton imgBtm;
    ImageView imgView;
    TextView txt_View;
    EditText editText;

    private CountDown countDown;

    private long timeElapsed;
    private TextView timeElapsedView;
    private final long startTime = 300 * 1000;
    private final long interval = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        control();

        setDrawable();

        countDown = new CountDown(startTime,interval);
        countDown.start();

//        imgBtm.setOnClickListener(this::setImgBtm);
    }

    private void control() {
//        imgBtm = findViewById(R.id.img_btm);
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

//    private void setImgBtm(View view) {
//        Toast.makeText(this, "Time not set", Toast.LENGTH_LONG).show();
//    }

