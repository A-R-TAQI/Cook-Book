package com.example.cookbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_DURATION = 2000; // 2 seconds
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start HomeActivity after the splash duration
                Intent intent = new Intent(SplashActivity.this, SigninActivity.class);
                startActivity(intent);
                finish(); // Close the splash screen activity
            }
        }, SPLASH_DURATION);
    }
}