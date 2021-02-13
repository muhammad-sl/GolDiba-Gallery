package com.navin.goldibaproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
TextView goldiba,hesiziba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        goldiba = findViewById(R.id.text_goldiba);
        hesiziba = findViewById(R.id.text_hesiziba);

        Animation animation_goldiba = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        goldiba.startAnimation(animation_goldiba);

        Animation animation_hesiziba = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in2);
        hesiziba.startAnimation(animation_hesiziba);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(new Intent(SplashScreen.this,MainActivity.class));
            finish();
        }, 3000);
    }
}