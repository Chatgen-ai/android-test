package com.example.ui;

import android.app.Activity;
import android.util.Log;
import android.webkit.JavascriptInterface;

public class JSInterface {
    private Activity activity;

    public JSInterface(Activity activity) {
        this.activity = activity;
    }

    @JavascriptInterface
    public void execute(String msg) {
        Log.d("execute", msg);
    }
}
