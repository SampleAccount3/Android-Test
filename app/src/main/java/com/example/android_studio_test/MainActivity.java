package com.example.android_studio_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btnStart,btnStop, btnReset;
    private int seconds;
    private boolean isRunning = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnReset = findViewById(R.id.btnReset);
        RunTimer();

        btnStart.setOnClickListener(v ->{
            isRunning = true;
            RunTimer();
        });
        btnStop.setOnClickListener(v ->{
            isRunning = false;
        });
        btnReset.setOnClickListener(v ->{
            seconds = 0;
        });


    }

    private void RunTimer(){
        final TextView tvTimer = findViewById(R.id.tvTimer);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minute = (seconds%3600)/60;
                int secs = seconds%60;

                String time = String.format(Locale.getDefault(),"%d:%02d:%02d", hours,minute,secs);
                tvTimer.setText(time);

                if (isRunning){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });


    }
}