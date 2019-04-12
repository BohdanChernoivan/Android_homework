package com.example.dz_22_factorial.logic;

public abstract class BackgroundTask<Argument, Result> {

    abstract Result doInBackground(Argument argument);

    protected abstract void onPostExecute(Result result);

    protected abstract void onProgressUpdate(int progress);

    void publishProgress(int progress) {
        //
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
