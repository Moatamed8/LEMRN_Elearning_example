package com.example.moatamed.gproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Results extends AppCompatActivity {
    private Toolbar mToolbar;
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mToolbar=(Toolbar)findViewById(R.id.result_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Results");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        webView=(WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.zu.edu.eg/ServiceDetails.aspx?ID=25");

        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);



    }

    @Override
    public void onBackPressed() {
       if (webView.canGoBack()){
           webView.goBack();
       }else{
        super.onBackPressed();}
    }
}
