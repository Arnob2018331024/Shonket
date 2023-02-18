package com.example.shonket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        pb=findViewById(R.id.progress_barr);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
            }
        });
        thread.start();

    }
    void doWork(){
        for(int i=25;i<=100;i+=25)
        try {
            Thread.sleep(1000);
            pb.setProgress(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent iHome=new Intent(SplashScreen.this,MainActivity.class);
        startActivity(iHome);
        finish();

    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }
}