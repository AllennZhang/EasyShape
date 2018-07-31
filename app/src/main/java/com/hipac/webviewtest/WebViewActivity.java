package com.hipac.webviewtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity{

    private WebView webView;

    public static void startActivity(Activity activity, String url){
        Intent intent = new Intent(activity,WebViewActivity.class);
        intent.putExtra("url",url);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weview);
        webView = findViewById(R.id.webview);
        init();
        if (getIntent()!= null) {
            String url = getIntent().getStringExtra("url");
            webView.loadUrl(url);
        }
    }

    private void init() {
        initSettings(webView);
        webView.setWebChromeClient(new WebChromeClient(){

        });

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

        });
    }


    private static void initSettings(WebView mWebView) {
        // 构建WebView配置WebSetting
        final WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        /**缩放*/
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        /*webview内容可超出屏幕*/
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);

        /* 防止其他应用隐藏执行脚本 */
        webSettings.setAllowFileAccess(false);
        webSettings.setAllowContentAccess(false);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        /* 缓存  */
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);

        /*不支持多窗口*/
        webSettings.setSupportMultipleWindows(false);

        //mWebView.setLayerType(View.LAYER_TYPE_NONE, null);

        // 配置WebView
        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mWebView.setWillNotCacheDrawing(false);

    }
}
