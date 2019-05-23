package com.example.dz_21.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dz_21.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DaysOfWeekFragment extends Fragment {

    Calendar calendar;
    SimpleDateFormat dateFormat;

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_days_of_week, container, false);

        dateFormat = new SimpleDateFormat("EEEE");

        one = view.findViewById(R.id.oneDay);
        two = view.findViewById(R.id.twoDay);
        three = view.findViewById(R.id.threeDay);
        four = view.findViewById(R.id.fourDay);
        five = view.findViewById(R.id.fiveDay);
        six = view.findViewById(R.id.sixDay);
        seven = view.findViewById(R.id.sevenDay);

        setDateFormat();

        return view;
    }

    private void setDateFormat() {

        calendar = new GregorianCalendar(1997, Calendar.NOVEMBER, 16);
        one.setText(dateFormat.format(calendar.getTime()));

        calendar = new GregorianCalendar(1997, Calendar.NOVEMBER, 17);
        two.setText(dateFormat.format(calendar.getTime()));

        calendar = new GregorianCalendar(1997, Calendar.NOVEMBER, 18);
        three.setText(dateFormat.format(calendar.getTime()));

        calendar = new GregorianCalendar(1997, Calendar.NOVEMBER, 19);
        four.setText(dateFormat.format(calendar.getTime()));

        calendar = new GregorianCalendar(1997, Calendar.NOVEMBER, 20);
        five.setText(dateFormat.format(calendar.getTime()));

        calendar = new GregorianCalendar(1997, Calendar.NOVEMBER, 21);
        six.setText(dateFormat.format(calendar.getTime()));

        calendar = new GregorianCalendar(1997, Calendar.NOVEMBER, 22);
        seven.setText(dateFormat.format(calendar.getTime()));

    }
}
