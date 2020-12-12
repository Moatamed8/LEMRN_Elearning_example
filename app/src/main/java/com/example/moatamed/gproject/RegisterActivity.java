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
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout mDisplayName;
    private TextInputLayout mDisplayLastName;
    private TextInputLayout mEmail;
    private TextInputLayout mPass;
    private FirebaseAuth mAuth;
    private Button mCreatebtn;
    private Toolbar mtoolbar;
    private DatabaseReference mDatabase;


    private ProgressDialog mprogressD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();



        mtoolbar=(Toolbar)findViewById(R.id.register_toolbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("Create Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mDisplayName = (TextInputLayout)findViewById(R.id.reg_Display_name);
        mDisplayLastName = (TextInputLayout)findViewById(R.id.reg_lastname);


        mEmail=(TextInputLayout)findViewById(R.id.reg_email);
        mPass = (TextInputLayout)findViewById(R.id.reg_pass);
        mCreatebtn = (Button) findViewById(R.id.start_reg_btn);

        mprogressD =new ProgressDialog(this);
    }

    public void btnNeed(View view) {

        String display_name = mDisplayName.getEditText().getText().toString();
        String display_lastname = mDisplayLastName.getEditText().getText().toString();

        String email = mEmail.getEditText().getText().toString();
        String password = mPass.getEditText().getText().toString();

        if(!TextUtils.isEmpty(display_name) ||!TextUtils.isEmpty(display_lastname) || !TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)){
            mprogressD.setTitle("Registering User ");
            mprogressD.setMessage("Please wait while creating account !");
            mprogressD.setCanceledOnTouchOutside(false);
            mprogressD.show();

            register_user(display_name, email, password);
        }
    }

    private void register_user(final String display_name, String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){


                    FirebaseUser current_user = FirebaseAuth.getInstance().getCurrentUser();
                    String uid = current_user.getUid();

                    mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);



                    HashMap<String, String> userMap = new HashMap<>();
                    userMap.put("name", display_name);
                    userMap.put("status", "First Grade");
                    userMap.put("image", "default");
                    userMap.put("thumb_image", "default");

                    mDatabase.setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()){

                                mprogressD.dismiss();

                                Intent mainIntent = new Intent(RegisterActivity.this, StudentActivity.class);
                                mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(mainIntent);
                                finish();
                            }

                        }
                    });


                }else {
                try {
                    throw task.getException();
                } catch(FirebaseAuthWeakPasswordException e) {
                    mPass.setError("weak password");
                    mPass.requestFocus();
                } catch(FirebaseAuthInvalidCredentialsException e) {
                    mEmail.setError("invalid credential exception");
                    mEmail.requestFocus();
                } catch(FirebaseAuthUserCollisionException e) {
                    mEmail.setError("collision exception");
                    mEmail.requestFocus();}
                catch (Exception e) {
                    e.getMessage();
                }
                mprogressD.hide();
                // If sign in fails, display a message to the user.
                //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                Toast.makeText(RegisterActivity.this, "Cannot Sign Up !!please check again", Toast.LENGTH_SHORT).show();



            }
            }
        });

    }


}