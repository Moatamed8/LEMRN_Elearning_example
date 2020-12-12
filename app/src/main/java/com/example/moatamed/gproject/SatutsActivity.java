package com.example.moatamed.gproject;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SatutsActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TextInputLayout mStatus;
    private Button mSavebtn;
    private DatabaseReference mStatusDataBase;
    private FirebaseUser mCurrentUser;
    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satuts);


        mCurrentUser= FirebaseAuth.getInstance().getCurrentUser();
        String uid=mCurrentUser.getUid();
        mStatusDataBase= FirebaseDatabase.getInstance().getReference().child("Users").child(uid);
        mToolbar=(Toolbar)findViewById(R.id.setting_status_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Account Status");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String status_value=getIntent().getStringExtra("status_value");
        mStatus=(TextInputLayout)findViewById(R.id.status_input);
        mSavebtn=(Button) findViewById(R.id.status_save_btn);
        mStatus.getEditText().setText(status_value);
    }
    public void btnSave(View view) {
        mProgress=new ProgressDialog(SatutsActivity.this);
        mProgress.setTitle("Saving Changes");
        mProgress.setMessage("Please wait while we save the changes");
        mProgress.show();

        String status=mStatus.getEditText().getText().toString();
        mStatusDataBase.child("status").setValue(status).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    mProgress.dismiss();
                }else {

                    Toast.makeText(getApplicationContext(),"Error!! Try Again",Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
