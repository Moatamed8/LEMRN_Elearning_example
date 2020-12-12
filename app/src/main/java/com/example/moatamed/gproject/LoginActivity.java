package com.example.moatamed.gproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TextInputLayout mLoginEmail;
    private TextInputLayout mLoginPass;
    private Button mLogin;
    private ProgressDialog mLoginProgress;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();


        mToolbar=(Toolbar)findViewById(R.id.login_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mLoginEmail =(TextInputLayout)findViewById(R.id.login_email);
        mLoginPass=(TextInputLayout)findViewById(R.id.login_password);
        mLogin=(Button)findViewById(R.id.login_btn);
        mLoginProgress=new ProgressDialog(this);
    }

    public void btnLogin(View view) {
        String email = mLoginEmail.getEditText().getText().toString();
        String password = mLoginPass.getEditText().getText().toString();

        if(!TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)){

            mLoginProgress.setTitle("LOGING IN ");
            mLoginProgress.setMessage("Please wait while login account !");
            mLoginProgress.setCanceledOnTouchOutside(false);
            mLoginProgress.show();
            LoginUser(email ,password);
        }
    }

    private void LoginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
           if (task.isSuccessful()){
               mLoginProgress.dismiss();
               Intent home=new Intent(LoginActivity.this,StudentActivity.class);
               startActivity(home);
               finish();
           }
           else {

               mLoginProgress.hide();
               // If sign in fails, display a message to the user.
               //Log.w(TAG, "createUserWithEmail:failure", task.getException());
               Toast.makeText(LoginActivity.this, "Please check username and password again", Toast.LENGTH_SHORT).show();

           }
            }
        });
    }

    public void BtnFGo(View view) {
        Intent home=new Intent(LoginActivity.this,ForgotPass.class);
        startActivity(home);
    }
}
