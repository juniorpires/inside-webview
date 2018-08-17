package com.github.juniorpires.insidewebview.ui;


import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.github.juniorpires.insidewebview.R;

import models.InsideWebViewClient;
import tools.AndroidUtils;

public class MainActivity extends AppCompatActivity {

    public static final String URL = "https://www.google.com.br/";

    View view;

    private WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initInstances();
        setContentView(this.view);


        this.myWebView = (WebView) findViewById(R.id.webview);

        myWebView.setWebViewClient(new InsideWebViewClient(this));

        myWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);

        myWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        init();
    }

    private void init() {
        if(this.checkNetwork()) {
            this.startWebView();
        }
    }

    private void startWebView() {
        this.myWebView.loadUrl(URL);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            this.myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }

    private boolean checkNetwork(){
        if(!AndroidUtils.isNetworkAvailable(this)){
            Snackbar.make(this.view, R.string.msg_network_error,Snackbar.LENGTH_INDEFINITE).setAction(R.string.bt_update_network, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    init();
                }
            }).show();

            return false;
        }

        return true;
    }



    private void initInstances() {
        this.view = View.inflate(this, R.layout.activity_main,null);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
