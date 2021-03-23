package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;

import android.view.View;

public class MainActivity extends AppCompatActivity {

    private int mCount;
    private TextView countView;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countView = (TextView) findViewById(R.id.show_count);
        countView.setText("0");
        getSupportActionBar().hide();
        final WebView myView = (WebView) findViewById(R.id.chatgen_widget);
        myView.setWebChromeClient(new WebChromeClient());
        myView.setWebViewClient(new WebViewClient());
        myView.getSettings().setJavaScriptEnabled(true);
        JSInterface jsInterface = new JSInterface(this);
        myView.addJavascriptInterface(jsInterface, "JSInterface");
        myView.loadUrl("https://test.chatgen.ai/cmp/chat-demo/?key=0jLwTEse&server=test");
        webView = myView;
    }

    public void countUp(View v) {
        View layout = (RelativeLayout) findViewById(R.id.web_view_container);
        ViewGroup.LayoutParams params = layout.getLayoutParams();
        if (params.width == RelativeLayout.LayoutParams.MATCH_PARENT) {
            params.width = 0;
        }
        else {
            params.width = RelativeLayout.LayoutParams.MATCH_PARENT;
        }
        layout.setLayoutParams(params);
    }
}
