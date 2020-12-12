package com.example.moatamed.gproject;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPass extends AppCompatActivity {
    private Toolbar mToolbar;
    private EditText userEmail;
    ProgressBar progressBar;
    ProgressDialog  mLoginProgress;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        mToolbar=(Toolbar)findViewById(R.id.forgot_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Reset Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        userEmail=(EditText)findViewById(R.id.forgot_email);

        mLoginProgress =new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
    }

    public void BtnForgot(View view) {
        mLoginProgress.setTitle("RESETING ");
        mLoginProgress.setMessage("Please wait while send email !");
        mLoginProgress.setCanceledOnTouchOutside(false);
        mLoginProgress.show();


        firebaseAuth.sendPasswordResetEmail(userEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
               if (task.isSuccessful()){

                    mLoginProgress.dismiss();
                  Toast.makeText(ForgotPass.this, "Password sent to your email", Toast.LENGTH_SHORT).show();

               }else {
                   Toast.makeText(ForgotPass.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();

               }
            }
        });
    }
}
