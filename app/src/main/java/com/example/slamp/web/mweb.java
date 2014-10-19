package com.example.slamp.web;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class mweb extends Activity {

    private WebView mWebView;
    private WebView mWebView2;
    private WebView mWebView3;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mweb);

        mWebView = (WebView) findViewById(R.id.webview1);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("http://www.vg.no");
        mWebView.setWebViewClient(new mwebClient());
        addWebViewTouchEvent(mWebView);

        mWebView2 = (WebView) findViewById(R.id.webview2);
        mWebView2.getSettings().setJavaScriptEnabled(true);
        mWebView2.loadUrl("http://www.db.no");
        mWebView2.setWebViewClient(new mwebClient());
        addWebViewTouchEvent(mWebView2);

        mWebView3 = (WebView) findViewById(R.id.webview3);
        mWebView3.getSettings().setJavaScriptEnabled(true);
        mWebView3.loadUrl("http://www.tk.no");
        mWebView3.setWebViewClient(new mwebClient());
        addWebViewTouchEvent(mWebView3);
    }

    private class mwebClient extends WebViewClient {

        public boolean shouldOverrideUrlLoading(WebView webView, String url)
        {
            webView.loadUrl(url);
            return true;
        }
    }
    public void onClickWebView1(View view) {
        mWebView.bringToFront();
    }
    public void onClickWebView2(View view) {
        mWebView2.bringToFront();
    }
    public void onClickWebView3(View view) {
        mWebView3.bringToFront();
    }

    public void addWebViewTouchEvent(WebView webview) {

        webview.setOnTouchListener(new View.OnTouchListener() {
//            public final static int FINGER_RELEASED = 0;
//            public final static int FINGER_TOUCHED = 1;
//            public final static int FINGER_DRAGGING = 2;
//            public final static int FINGER_UNDEFINED = 3;
//
//            private int fingerState = FINGER_RELEASED;

            private float x1,x2;
            static final int MIN_DISTANCE =500;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch(motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        x1 = motionEvent.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        x2 = motionEvent.getX();
                        float deltaX = x2 - x1;
                        if (Math.abs(deltaX) > MIN_DISTANCE) {
                            Log.i("MotionEvent", String.valueOf(deltaX));
                            if (deltaX > 0) {
                                Log.i("MotionEvent", "leftr2right");
                            } else {
                                Log.i("MotionEvent", "right2left");
                            }

                        } else {
                            // consider as something else - a screen tap for example
                        }
                        break;
                }
                return false;

//                switch (motionEvent.getAction()) {
//
//                    case MotionEvent.ACTION_DOWN:
//                        if (fingerState == FINGER_RELEASED) fingerState = FINGER_TOUCHED;
//                        else fingerState = FINGER_UNDEFINED;
//                        break;
//
//                    case MotionEvent.ACTION_UP:
//                        if(fingerState != FINGER_DRAGGING) {
//                            fingerState = FINGER_RELEASED;
//
//                            // Your onClick codes
//
//                        }
//                        else if (fingerState == FINGER_DRAGGING) fingerState = FINGER_RELEASED;
//                        else fingerState = FINGER_UNDEFINED;
//                        break;
//
//                    case MotionEvent.ACTION_MOVE:
//                        if (fingerState == FINGER_TOUCHED || fingerState == FINGER_DRAGGING) fingerState = FINGER_DRAGGING;
//                        else fingerState = FINGER_UNDEFINED;
//                        break;
//
//                    default:
//                        fingerState = FINGER_UNDEFINED;
//
//                }
            }
        });

    }
}
