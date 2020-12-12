package com.example.moatamed.gproject;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Security extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);
        final TextView time = (TextView) findViewById(R.id.txtcntDwn);

        final GregorianCalendar currentTime = new GregorianCalendar(2014, 9, 1, 9, 16, 0);
        GregorianCalendar targetTime = new GregorianCalendar(2016, 5, 1, 11, 2, 0);
        long difference = targetTime.getTimeInMillis() - currentTime.getTimeInMillis();
        new CountDownTimer(difference, 1000) {

            @Override
            public void onTick(long arg0) {
                Calendar countdownDuration = Calendar.getInstance();
                countdownDuration.setTimeInMillis(currentTime.getTimeInMillis() + arg0);
                int year = countdownDuration.get(Calendar.YEAR) - currentTime.get(Calendar.YEAR);
                int month = countdownDuration.get(Calendar.MONTH);
                int day = countdownDuration.get(Calendar.DAY_OF_MONTH) - 1;
                int hour = countdownDuration.get(Calendar.HOUR);
                int minute = countdownDuration.get(Calendar.MINUTE);
                int sec = countdownDuration.get(Calendar.SECOND);

                time.setText("Years: " + year + "\nMonth:" + month + "\nDays:" + day + "\nHour:" + hour
                        + "\nMinute" + minute + "\nSecond:" + sec);

            }

            @Override
            public void onFinish() {
                // TODO Auto-generated method stub

            }
        }.start();
    }
}