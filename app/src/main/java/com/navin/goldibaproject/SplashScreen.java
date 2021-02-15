package com.navin.goldibaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
TextView goldiba,hesiziba,txt_internet_error;
RelativeLayout try_again;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        goldiba = findViewById(R.id.text_goldiba);
        hesiziba = findViewById(R.id.text_hesiziba);
        try_again = findViewById(R.id.rel_try_again);
        txt_internet_error = findViewById(R.id.txt_internet_error);


        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;

        }



        Animation animation_goldiba = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        goldiba.startAnimation(animation_goldiba);

        Animation animation_hesiziba = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in2);
        hesiziba.startAnimation(animation_hesiziba);

        boolean finalConnected = connected;
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if(finalConnected){
                startActivity(new Intent(SplashScreen.this,MainActivity.class));
                finish();

            }else {
                txt_internet_error.setVisibility(View.VISIBLE);
                try_again.setVisibility(View.VISIBLE);
                try_again.setOnClickListener(v -> {
                    recreate();


                });



            }

        }, 2000);
    }
}