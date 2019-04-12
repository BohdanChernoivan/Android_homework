package com.example.dz_22_factorial.logic;

public abstract class FactorialCalculationTask extends BackgroundTask<Long, Long> {

    @Override
    Long doInBackground(Long n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
            int progress = (int) ((double) i / n * 100);
            demonstrationDelay();
            if (isCanceled()) break;
            publishProgress(progress);
        }
        return result;
    }

    private void demonstrationDelay() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }
}
