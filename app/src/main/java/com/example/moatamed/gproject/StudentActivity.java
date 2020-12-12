package com.example.moatamed.gproject;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StudentActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        TextView textView = findViewById(R.id.textview);
        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);

        setColorStateList(textView);
        setColorStateList(textView1);
        setColorStateList(textView2);
        setColorStateList(textView3);








        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mAuth = FirebaseAuth.getInstance();



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void setColorStateList(TextView view) {
        int[][] states = new int[][] {
                new int[] { android.R.attr.state_pressed}, // pressed
                new int[] { android.R.attr.state_focused}, // focused
                new int[] { android.R.attr.state_enabled}  // enabled
        };

        int[] colors = new int[] {
                getResources().getColor(R.color.blue),
                getResources().getColor(R.color.green),
                getResources().getColor(R.color.green)
        };

        ColorStateList list = new ColorStateList(states, colors);
        view.setTextColor(list);
        view.setClickable(true);
        view.setFocusableInTouchMode(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.myaccount) {
            Intent home =new Intent(StudentActivity.this,AccountSetting.class);
            startActivity(home);
            // Handle the camera action
        } else if (id == R.id.courses) {
            Intent home =new Intent(StudentActivity.this,Courses.class);
            startActivity(home);


        } else if (id == R.id.schedule) {
            Intent home =new Intent(StudentActivity.this,Schedule.class);
            startActivity(home);

        } else if (id == R.id.results) {
            Intent home =new Intent(StudentActivity.this,Results.class);
            startActivity(home);

        } else if (id == R.id.about) {
            Intent home =new Intent(StudentActivity.this,AboutF.class);
            startActivity(home);

        } else if (id == R.id.nav_share) {
            Intent home =new Intent(StudentActivity.this,ShareF.class);
            startActivity(home);

        } else if (id == R.id.nav_send) {

        }
        else if (id == R.id.log) {
            FirebaseAuth.getInstance().signOut();
            sendToStart();

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /////
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser ==null){


            sendToStart();


        }
    }
    private void sendToStart() {
        Intent StartIntent = new Intent(StudentActivity.this,StartActivity.class);
        startActivity(StartIntent);
        finish();
    }

    public void BtnLog(View view) {
        FirebaseAuth.getInstance().signOut();
        sendToStart();

    }

    public void BtnFirst(View view) {
        Intent home1=new Intent(StudentActivity.this,FirstYear.class);
        startActivity(home1);
    }

    public void BtnFourth(View view) {
        Intent home2=new Intent(StudentActivity.this,FourthYear.class);
        startActivity(home2);
    }

    public void BtnSecond(View view) {
        Intent home3=new Intent(StudentActivity.this,SecondYear.class);
        startActivity(home3);
    }

    public void BtnThird(View view) {
        Intent home4=new Intent(StudentActivity.this,ThirdYear.class);
        startActivity(home4);
    }
}
