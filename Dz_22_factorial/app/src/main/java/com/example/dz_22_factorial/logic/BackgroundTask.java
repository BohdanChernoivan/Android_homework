package com.example.dz_22_factorial.logic;

import android.widget.TextView;

import com.example.dz_22_factorial.R;

public abstract class BackgroundTask<Argument, Result> {

    abstract Result doInBackground(Argument argument);

    protected abstract void onPostExecute(Result result);

    protected abstract void onProgressUpdate(int progress);

    protected void publishProgress(int progress) {
//        TextView textView = find
    }

    public void execute(Argument argument) {
        //
    }

    boolean isCanceled() {
        //
        return true;
    }

    void cancel() {
        //
    }
}
