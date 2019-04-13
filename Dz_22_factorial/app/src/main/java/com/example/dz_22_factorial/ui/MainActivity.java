package com.example.dz_22_factorial.ui;

import android.content.Context;
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

    BackgroundTask<Long, Long> task = new FactorialCalculationTask() {

        @Override
        protected void onPostExecute(Long result) {
            resultTextView.setText(result.toString());

        }

        @Override
        protected void onProgressUpdate(int progress) {
            progressBar.setProgress(progress);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        control();

//        task.execute(Long.valueOf(inputTextView.getText().toString()));
    }


    private void control() {
        resultTextView = findViewById(R.id.answer);
        progressBar = findViewById(R.id.barProgress);
        inputTextView = findViewById(R.id.inputTextView);
    }

    protected class Kfc extends Thread {
        protected MainActivity context;

        public Kfc(Context context){
            this.context = (MainActivity) context;
        }

        public void updateTV(final String str1){
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                context.resultTextView.setText(str1);
            }
        });
        }
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.startBtm:
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

                        long n = Long.valueOf(inputTextView.getText().toString()); // Integer.parseInt(q);
                        long result = 1;

                        Log.i(STR, " INPUT = " + n);

                        for (int i = 1; i <= n; i++) {
                            result = result * i;
//                            int progress = (int) ((double) i / n * 100);
                        }

                        Log.i(STR, " Res = " + result);
//                        resultTextView.setText("ds");
                    }
                }).start();

                Kfc kfc = new Kfc(this);
                kfc.updateTV("432");
        }
    }
}
