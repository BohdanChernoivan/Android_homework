package com.example.dz_13.myHelper;

import android.widget.TextView;

import java.util.Locale;

public class Substitution {

    /**
     *
     * @param textView our text view
     * @param i returns number in TextView
     */
    public void substitution(TextView textView, int i) {
        textView.setText(String.format(Locale.getDefault(), "%d", i));
    }
}
