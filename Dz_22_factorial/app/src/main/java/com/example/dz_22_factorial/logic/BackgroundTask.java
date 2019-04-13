package com.example.dz_22_factorial.logic;



public abstract class BackgroundTask<Argument, Result> {

    Thread thread = new Thread();

    abstract Result doInBackground(Argument argument);

    protected abstract void onPostExecute(Result result);

    protected abstract void onProgressUpdate(int progress);

    protected void publishProgress(int progress) {
//        long p = Long.valueOf(progress);
//        int result = 1;
//        for (int i = 1; i <= p; i++) {
//            result = result * i;
//        }
    }

    public void execute(Argument argument) {
//        thread(new Runnable() {
//            @Override
//            public void run() {
//                resultTextView.setText(str1);
//            }
//        });
    }

    boolean isCanceled() {
        if(!thread.isInterrupted()){
            return true;
        }
        else return false;
    }

    void cancel() {
        thread.interrupted();
    }
}
