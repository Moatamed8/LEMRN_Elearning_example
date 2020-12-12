package com.example.moatamed.gproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondYear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_year);
    }

    public void DataBaseBtnGo2(View view) {
        Intent home=new Intent(SecondYear.this,DataSecurity.class);
        startActivity(home);
    }

    public void EthicsBtnGo2(View view) {
        Intent home=new Intent(SecondYear.this,IntroductionF.class);
        startActivity(home);

    }

    public void AlgorithmsGo(View view) {
        Intent home=new Intent(SecondYear.this,MangementF.class);
        startActivity(home);
    }
}
