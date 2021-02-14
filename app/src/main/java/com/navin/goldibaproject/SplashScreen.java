package com.navin.goldibaproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {
TextView goldiba,hesiziba,txt_error_network,txt_try_again;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        goldiba = findViewById(R.id.text_goldiba);
        hesiziba = findViewById(R.id.text_hesiziba);
        txt_error_network = findViewById(R.id.txt_internet_error);
        txt_try_again = findViewById(R.id.txt_try_network_again);

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
                txt_error_network.setVisibility(View.VISIBLE);
                txt_try_again.setVisibility(View.VISIBLE);
                txt_try_again.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        recreate(); //This method is only available on Android version 11 and above
                    }
                });

            }

        }, 3000);
    }
}