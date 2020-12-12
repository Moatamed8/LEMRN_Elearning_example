package com.example.moatamed.gproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ThirdYear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_year);
    }

    public void EthicsBtnGo(View view) {
        Intent home=new Intent(ThirdYear.this,IntroductionF.class);
        startActivity(home);
    }

    public void DataBaseBtnGo(View view) {
        Intent home=new Intent(ThirdYear.this,DataSecurity.class);
        startActivity(home);
    }
}
