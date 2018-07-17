package com.example.saurabh.wikipediasearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {
    private WebView mWebView;
    private String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWebView = (WebView) findViewById(R.id.webview);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mTitle = extras.getString("title");
        }
        mWebView.getSettings().getJavaScriptEnabled();
        mWebView.loadUrl("https://en.m.wikipedia.org/wiki/" + mTitle);


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (mWebView.canGoBack()) {
                        mWebView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
