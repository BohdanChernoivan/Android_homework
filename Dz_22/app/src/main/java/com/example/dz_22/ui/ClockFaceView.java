package com.example.dz_22.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.Calendar;


public class ClockFaceView extends View {

    Canvas canvas;
    Paint paint = new Paint();
    Paint p = new Paint();
    SecondView secondView;


    public ClockFaceView(Context context) {
        super(context);
    }

    public ClockFaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ClockFaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        secondView = new SecondView();

        this.canvas = canvas;

        canvas.drawARGB(80, 102, 204, 255);

        paint.setColor(Color.BLACK);
        canvas.drawCircle(550, 800, 390, paint);

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

        p.setStrokeWidth(10);
        p.setColor(Color.WHITE);
        Toast.makeText(getContext(), Datetime(), Toast.LENGTH_SHORT).show();

        secondView.draw(canvas, p, Datetime());


                /*
                 * x1 = (int) (x0 + (radius * Math.cos(a)));
                 * y1 = (int) (y0 + (radius * Math.sin(a)));
                 * */

    }


    public static String Datetime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("ss");
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }
}

