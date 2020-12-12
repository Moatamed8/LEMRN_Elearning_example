package com.example.moatamed.gproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Courses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
    }

    public void BtnOpen(View view) {
        Intent home =new Intent(Courses.this,AnVideos.class);
        startActivity(home);
    }

    public void POpen(View view) {
        Intent home =new Intent(Courses.this,PhpCor.class);
        startActivity(home);
    }

    public void BtnjavaCo(View view) {
        Intent home =new Intent(Courses.this,JavaCor.class);
        startActivity(home);
    }

    public void BtnCorShare(View view) {
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
            String shareMessage= "\nLet me recommend you this application\n\n";
            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch(Exception e) {
            //e.toString();
        }
    }
}
