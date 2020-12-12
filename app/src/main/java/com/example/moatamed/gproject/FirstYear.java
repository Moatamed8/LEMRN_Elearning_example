package com.example.moatamed.gproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FirstYear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_year);
    }

    public void BtnIntroduction(View view) {
        Intent home =new Intent(FirstYear.this,IntroductionF.class);
        startActivity(home);
    }
    public void BtnMangement(View view) {
        Intent home =new Intent(FirstYear.this,MangementF.class);
        startActivity(home);
    }
}
