package com.navin.goldibaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    LottieAnimationView animationView;
    AlertDialog alertDialog = new AlertDialog(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.goldiba_site);


        if (savedInstanceState != null)
            ((WebView) findViewById(R.id.goldiba_site)).restoreState(savedInstanceState);

        animationView = findViewById(R.id.animation_loading);
        animationView.setVisibility(View.VISIBLE);
        String url_agah = "https://www.goldiba.com/";

        webView.loadUrl(url_agah);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);


        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().enableSmoothTransition();

        webView.setWebViewClient(new MyWebViewClient());

        webView.setDownloadListener((url, userAgent, contentDisposition, mimetype, contentLength) -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
    }


    //we use this class to open links in webview exept browser
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            animationView.setVisibility(View.GONE);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
    }

    @Override
    public void onBackPressed() {
        Log.e("","");
        if (webView != null && webView.canGoBack()) {
            webView.goBack(); // if there is previous page open it
        } else{
            alertDialog.exit_dialog();
        }




    }

}


