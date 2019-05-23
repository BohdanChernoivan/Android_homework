package com.example.dz_22_factorial.logic;


import android.os.Handler;
import android.widget.TextView;

public abstract class BackgroundTask<Argument, Result> {

    Thread thread;
    Runnable runnable;
    Handler handler;

    public abstract Result doInBackground(Argument argument);

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public abstract void onPostExecute(Result result);

    public abstract void onProgressUpdate(int progress);

    public void publishProgress(final int progress) {

        runnable = new Runnable() {
            @Override
            public void run() {
                onProgressUpdate(progress);
            }
        };

        handler.post(runnable);
    }

    public void execute(final Argument argument) {

        runnable = new Runnable() {
            @Override
            public void run() {
                Result result = doInBackground(argument);
                onPostExecute(result);
            }
        };

        thread = new Thread(runnable);
        thread.start();

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
