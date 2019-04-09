package com.example.dz_22.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.Calendar;


public class ClockFaceView extends View {

    Paint paint = new Paint();

    Paint p = new Paint();

    Handler handler = new Handler();

//    RectF rectf;

    public ClockFaceView(Context context) {
        super(context);
//        rectf = new RectF(120,800,550,1230);
    }

    public ClockFaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ClockFaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void invalidate() {
        super.invalidate();
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

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


        Runnable fun = new Runnable() {
            @Override
            public void run() {

                handler.postDelayed(this,1000);

//                p.setStrokeWidth(10);
//                p.setColor(Color.WHITE);

                Toast.makeText(getContext(), Datetime(), Toast.LENGTH_SHORT).show();



                /*
                 * x1 = (int) (x0 + (radius * Math.cos(a)));
                 * y1 = (int) (y0 + (radius * Math.sin(a)));
                 * */

//                switch (Datetime()) {
//
//                    case "00":
//                        canvas.drawLine(550, 800, 550, 520, p);
//                        break;
//
//                    case "15":
//                        canvas.drawLine(550, 800, 850, 800, p);
//                        break;
//
//                    case "30":
//                        canvas.drawLine(550, 800, 550, 1100, p);
//                        break;
//
//                    case "45":
//                        canvas.drawLine(550, 800, 250, 800, p);
//                        break;
//
//                    default:
//                        canvas.drawLine(550, 800, 550, 520, p);
//                        Toast.makeText(getContext(), Datetime(), Toast.LENGTH_SHORT).show();
//                }
            }
        };


        handler.post(fun);

    }

    public static String Datetime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("ss");
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }
}

