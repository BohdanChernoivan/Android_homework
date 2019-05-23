package com.example.dz_22.ui;

import android.graphics.Canvas;
import android.graphics.Paint;

public class SecondView {

    private String str = "00";

    public void draw(Canvas canvas, Paint paint, String dateTime) {

        if(dateTime != "45" && dateTime != "30" && dateTime != "15" && dateTime != "00") {
            str = dateTime;
        }

        switch (str) {
            case "00":
                canvas.drawLine(550, 800, 550, 520, paint);
                str = "00";
                break;

            case "15":
                canvas.drawLine(550, 800, 850, 800, paint);
                str = "15";
                break;

            case "30":
                canvas.drawLine(550, 800, 550, 1100, paint);
                str = "30";
                break;

            case "45":
                canvas.drawLine(550, 800, 250, 800, paint);
                str = "45";
                break;

//                default:
//                    canvas.drawLine(550, 800, 550, 520, paint);
        }
    }
}
