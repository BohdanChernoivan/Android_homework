package com.example.dz_22_factorial.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.dz_22_factorial.R;
import com.example.dz_22_factorial.logic.BackgroundTask;
import com.example.dz_22_factorial.logic.FactorialCalculationTask;


public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private ProgressBar progressBar;
    private TextView inputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
        task.execute(Long.valueOf(inputTextView.getText().toString()));
    }

    public void onClick(View view) {

    }
}
