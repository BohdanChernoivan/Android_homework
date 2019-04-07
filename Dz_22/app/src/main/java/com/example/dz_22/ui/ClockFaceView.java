package com.example.dz_22.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class ClockFaceView extends View {

    Paint paint = new Paint();


    RectF rectf;

    public ClockFaceView(Context context) {
        super(context);
        init();

        rectf = new RectF(120,800,550,1230);

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

        canvas.drawARGB(80, 102, 204, 255);

        canvas.drawCircle(550, 800, 390, paint);

        paint.setStrokeWidth(10);
        paint.setColor(Color.WHITE);
        canvas.drawLine(550, 800, 550, 550, paint);

        paint.setStrokeWidth(20);
        paint.setColor(Color.RED);
        canvas.drawPoint(550, 800, paint);

        paint.setTextSize(40);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(Color.BLUE);
        canvas.drawText("0", 550, 400, paint);
        canvas.drawText("15", 980, 800, paint);
        canvas.drawText("30", 550, 1230, paint);
        canvas.drawText("45", 120, 800, paint);


        rectf.offsetTo(800, 150);
        rectf.inset(0, 0);
        canvas.drawArc(rectf, 90, 270, true, paint);
//        canvas.drawArc(500, 200,750, 150,90,170,false,paint);



    }


}
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
//
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
//
//        if(widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY) {
//            setMeasuredDimension(widthSize, heightSize);
//            return;
//        }
//
//        int min = Math.min(widthSize, heightSize);
//        setMeasuredDimension(min, min);
//
//    }

