package com.example.dz_22_factorial.logic;


import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public abstract class BackgroundTask<Argument, Result> {


    Thread thread = new Thread();


    public abstract Result doInBackground(Argument argument);

    public abstract void onPostExecute(Result result);

    public abstract void onProgressUpdate(int progress);

    public void publishProgress(int progress) {
        ProgressBar progressBar = null;
        progressBar.setProgress(progress);
    }

    public void execute(Argument argument, TextView textView) {
        textView.setText("" + doInBackground(argument));
    }

    boolean isCanceled() {
        if(!thread.isInterrupted()){
            return true;
        }
        else return false;
    }

    void cancel() {
        thread.interrupted();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
