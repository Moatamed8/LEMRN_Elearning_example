package com.example.moatamed.gproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {
    private Button regbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        regbtn=(Button)findViewById(R.id.start_reg_btn);
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home=new Intent(StartActivity.this,RegisterActivity.class);
                startActivity(home);
                finish();
            }
        });
    }

    public void btnGo(View view) {

        Intent home=new Intent(StartActivity.this,LoginActivity.class);
        startActivity(home);
        finish();

    }
}
