package com.example.moatamed.gproject;

import android.support.v4.app.Fragment;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class FourthYear extends AppCompatActivity {
    Spinner mSpinner;

    CScience cScience;
    ISystem iSystem;
    InforamtionTechnology inforamtionTechnology;
    DSupport dSupport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_year);

        mSpinner=findViewById(R.id.spinner);

        cScience=new CScience();
        iSystem=new ISystem();
        inforamtionTechnology=new InforamtionTechnology();
        dSupport=new DSupport();

        ArrayAdapter<String>adapter=new ArrayAdapter<>(FourthYear.this,R.layout.custome_spinner
        ,getResources().getStringArray(R.array.fragments));
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        setFragment(inforamtionTechnology);
                        break;
                    case 1:
                        setFragment(dSupport);
                        break;
                    case 2:
                        setFragment(iSystem);
                        break;
                    case 3:
                        setFragment(cScience);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    public void setFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
    }
    public void BtnDsp(View View){
        Intent home=new Intent(FourthYear.this,Dsp.class);
        startActivity(home);
    }
    public void BtnVR(View View){
        Intent home=new Intent(FourthYear.this,VirtualReality.class);
        startActivity(home);
    }

    public void BtnCloud(View view) {
        Intent home=new Intent(FourthYear.this,Cloud.class);
        startActivity(home);
    }

    public void BtnDataSecurity(View view) {
        Intent home=new Intent(FourthYear.this,DataSecurity.class);
        startActivity(home);
    }

    public void BtnParallel(View view) {
        Intent home=new Intent(FourthYear.this,Parallel.class);
        startActivity(home);

    }
    public void BtnSecurityGo(View view) {
        Intent home=new Intent(FourthYear.this,Security.class);
        startActivity(home);

    }
}
