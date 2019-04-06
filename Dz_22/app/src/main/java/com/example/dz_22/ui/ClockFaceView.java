package com.example.dz_22.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ClockFaceView extends View {

    Paint paint = new Paint();

    public ClockFaceView(Context context) {
        super(context);
        init();
    }

    public ClockFaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClockFaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint.setColor(Color.BLACK);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(0, 0, 20, 20, paint);
        canvas.drawLine(20, 0, 0, 20, paint);


        paint.setStrokeWidth(10);
        int startX = 20;
        int startY = 100;
        int stopX = 140;
        int stopY = 30;

        canvas.drawLine(startX, startY, stopX, stopY, paint);
    }
}
