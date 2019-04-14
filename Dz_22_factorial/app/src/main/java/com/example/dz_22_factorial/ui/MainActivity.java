package com.example.dz_22_factorial.ui;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.dz_22_factorial.R;
import com.example.dz_22_factorial.logic.BackgroundTask;
import com.example.dz_22_factorial.logic.FactorialCalculationTask;



public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private ProgressBar progressBar;
    private EditText inputTextView;
    private String STR = "TAG";
    Handler handler;

    BackgroundTask<Long, Long> task = new FactorialCalculationTask() {

        @Override
        public void onPostExecute(Long result) {
            resultTextView.setText(result.toString());
        }



        @Override
        public void onProgressUpdate(int progress) {
            for (int i = progress; i <= 100; i += 5) {
                try {
                    Thread.sleep(100);
                    progressBar.setProgress(i);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        control();

        handler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                resultTextView.setText("" + msg.what);
            }
        };
    }


    private void control() {
        resultTextView = findViewById(R.id.answer);
        progressBar = findViewById(R.id.barProgress);
        inputTextView = findViewById(R.id.inputTextView);
    }



    public void onClick(View view) {
        switch (view.getId()){
            case R.id.startBtm:
//                task.execute(Long.valueOf(inputTextView.getText().toString()), resultTextView);
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        for (int i = 0; i <= 100; i += 5) {
                            try {
                                Thread.sleep(100);
                                progressBar.setProgress(i);
                            } catch (InterruptedException e) {
                                break;
                            }
                        }


                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        progressBar.setProgress(0);

                        long n = Long.valueOf(inputTextView.getText().toString());

                        long result = 1;

                        Log.i(STR, " INPUT = " + n);

                        for (int i = 1; i <= n; i++) {
                            result = result * i;
                        }

                        handler.sendEmptyMessage((int)result);
                        Log.i(STR, " Res = " + result);
                    }
                }).start();

        }
    }
}